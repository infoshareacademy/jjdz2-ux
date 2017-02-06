package com.sionach.ux.keyWords;

import com.sionach.ux.databaseEntities.DomainsKeywordsDAO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class KeyWords {

    private Document doc;

    @Inject
    DomainsKeywordsDAO domainsKeywordsDAO;

    public List<KeywordsToView> keywordsPrintOnWebsite(Set<String> uniqKeywordsFromUrl, int domainId) throws UnsupportedEncodingException {
        List<KeywordsToView> keywordsObjectsList = new ArrayList<>();

        for(String item:uniqKeywordsFromUrl){
            KeywordsToView keywordsToAdd = new KeywordsToView();
            keywordsToAdd.setKeyword(item);
            keywordsToAdd.setGoogleLinkToKeyword(URLEncoder.encode(item, "UTF-8").toString());
            keywordsToAdd.setGlyphicon(checkKeywordsInDatabase(item, domainId));
            keywordsObjectsList.add(keywordsToAdd);
        }

        return keywordsObjectsList;
    }

    public String checkKeywordsInDatabase(String keyword, int domainId){
        if(domainsKeywordsDAO.isKeywordInDatabase(keyword, domainId)){
            return "glyphicon-ok";
        }else{
            return "glyphicon-heart";
        }
    }

    public Set<String> extractKeyWords(String link) throws IOException {
        Set<String> result = new HashSet<>();

        doc = Jsoup.connect(link).get();
        List<List<String>> keyWords = Arrays.asList(
                keywordsAnchor(),
                attributesKeywords(),
                boldedKeywords(),
                headlineKeywords(),
                metadataKeywords());

        result = keyWords.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        return result;
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
        List<String> anchor = new ArrayList<>();

        if (elements != null) {
            for (Element element : elements) {
                articlesList.add(element.toString());
            }

            String articles = String.join(" ", articlesList);

            Document linkdoc = Jsoup.parse(articles);
            Elements linkelements = linkdoc.select("a");
            for (Element item : linkelements) {
                if (item.text().length() > 1) {
                    anchor.add(item.text());
                }
            }
        } else {
            anchor = Collections.EMPTY_LIST;
        }
        return anchor;
    }

    private List<String> attributesKeywords() {
        List<String> attributesKeywordsList = new ArrayList<String>();
        Elements images = doc.select("img");

        if (images != null) {
            for (Element item : images) {
                if (item.attr("title").length() > 1) {
                    attributesKeywordsList.add(item.attr("title"));
                }
                if (item.attr("alt").length() > 1) {
                    attributesKeywordsList.add(item.attr("alt"));
                }
            }
        } else {
            attributesKeywordsList = Collections.EMPTY_LIST;
        }
        return attributesKeywordsList;
    }

    private List<String> boldedKeywords() {

        Elements elements = doc.select("strong, b");
        List<String> bolded = new ArrayList<>();
        if (elements != null) {
            for (Element element : elements) {
                if (element.text().split(" ").length <= 8) {
                    bolded.add(element.text());
                }
            }
        } else {
            bolded = Collections.EMPTY_LIST;
        }
        return bolded;
    }

    private List<String> headlineKeywords() {
        List<String> headlineKeywordsList = new ArrayList<String>();
        Elements linkelements = doc.select("h1, h2, h3");
        if (linkelements != null) {
            for (Element item : linkelements) {

                if (item.text().split(" ").length <= 8) {
                    headlineKeywordsList.add(item.text());
                }
            }
        } else {
            headlineKeywordsList = Collections.EMPTY_LIST;
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
                if (item.length() > 1) {
                    metaList.add(item.trim());
                }
            }
        } else {
            metaList = Collections.EMPTY_LIST;
        }
        return metaList;
    }
}
