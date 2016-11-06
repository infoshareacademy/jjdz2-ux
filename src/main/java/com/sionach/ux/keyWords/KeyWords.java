package com.sionach.ux.keyWords;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
public class KeyWords {

    private Document doc;

    public Set<String> extractKeyWords(String htmlCode) {

        doc = Jsoup.parse(htmlCode);
        List<List<String>> keyWords = Arrays.asList(
                keywordsAnchor(),
                attributesKeywords(),
                boldedKeywords(),
                headlineKeywords(),
                MetadataKeywords());

        return keyWords.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
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

    private List<String> MetadataKeywords() {
        Elements elements = doc.select("meta");
        List<String> metaList = new ArrayList<>();

        for (Element item : elements) {
            if (item.attr("charset").length() > 0) {
                metaList.add(item.attr("charset"));
            }
            if (item.attr("content").length() > 0) {
                metaList.add(item.attr("content"));
            }
            if (item.attr("http-equiv").length() > 0) {
                metaList.add(item.attr("http-equiv"));
            }
            if (item.attr("name").length() > 0) {
                metaList.add(item.attr("name"));
            }
            if (item.attr("scheme").length() > 0) {
                metaList.add(item.attr("scheme"));
            }
        }
        return metaList;
    }
}
