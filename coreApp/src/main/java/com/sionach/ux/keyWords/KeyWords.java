package com.sionach.ux.keyWords;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.ejb.Stateless;
import javax.ws.rs.PathParam;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class KeyWords {

    private Document doc;

    public Set<String> extractKeyWords(String link) {

        try {
            doc = Jsoup.connect(link).get();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("coś poszło nie tak ;p");
        }
        List<List<String>> keyWords = Arrays.asList(
                keywordsAnchor(),
                attributesKeywords(),
                boldedKeywords(),
                headlineKeywords(),
                metadataKeywords());


        return keyWords.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    public List<KeyWordsLinks> keyWordsListLinks(Set<String> keywordsList) throws UnsupportedEncodingException {
        List<KeyWordsLinks> keyWordsLinksList = new ArrayList<>();
        for (String item : keywordsList) {
            keyWordsLinksList.add(new KeyWordsLinks(item, URLEncoder.encode(item, "UTF-8")));
        }

        return keyWordsLinksList;
    }

    private List<String> keywordsAnchor() {
        Elements elements = doc.select("article");
        List<String> articlesList = new ArrayList<>();

        for (Element element : elements) {
            articlesList.add(element.toString());
        }

        String articles = String.join(" ", articlesList);

        List<String> anchor = new ArrayList<>();
        Document linkdoc = Jsoup.parse(articles);
        Elements linkelements = linkdoc.select("a");
        for (Element item : linkelements) {

            if (item.text().split(" ").length <= 8) {
                anchor.add(item.text());
            }
        }
        return anchor;
    }

    private List<String> attributesKeywords() {
        List<String> attributesKeywordsList = new ArrayList<String>();
        Elements images = doc.select("img");

        for (Element item : images) {
            if (item.attr("title").length() > 0) {
                attributesKeywordsList.add(item.attr("title"));
            }
            if (item.attr("alt").length() > 0) {
                attributesKeywordsList.add(item.attr("alt"));
            }
        }
        return attributesKeywordsList;
    }

    private List<String> boldedKeywords() {

        Elements elements = doc.select("strong, b");
        List<String> bolded = new ArrayList<>();

        for (Element element : elements) {
            if (element.text().split(" ").length <= 8) {
                bolded.add(element.text());
            }
        }
        return bolded;
    }

    private List<String> headlineKeywords() {
        List<String> headlineKeywordsList = new ArrayList<String>();
        Elements linkelements = doc.select("h1, h2, h3");
        for (Element item : linkelements) {

            if (item.text().split(" ").length <= 8) {
                headlineKeywordsList.add(item.text());
            }
        }
        return headlineKeywordsList;
    }

    private List<String> metadataKeywords() {
        List<String> metaList = new ArrayList<>();


        Element element = doc.select("meta[name=keywords]").first();
        if (element != null) {
            String[] keywords = element.attr("content").
                    split(",");
            for (String item : keywords) {
                if (item.length() > 0) {
                    metaList.add(item);
                }
            }
        } else {
            metaList = Collections.EMPTY_LIST;
        }
        return metaList;
    }
    //TODO trim dla keywords ze spacją
}
