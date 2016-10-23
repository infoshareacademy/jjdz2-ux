package com.sionach.ux.keyWords;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public class KeywordsFromAttributes {

    public List<String> attributesKeywords(String htmlCode) {
        List<String> attributesKeywordsList = new ArrayList<String>();
        Document doc = Jsoup.parse(htmlCode);
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

}
