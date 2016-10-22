package com.sionach.ux.keyWords;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public class KeywordsFromHeadlines {

    public List<String> headlineKeywords(String htmlCode) {
        List<String> headlineKeywordsList = new ArrayList<String>();
        Document doc = Jsoup.parse(htmlCode);
        Elements linkelements = doc.select("h1, h2, h3");
        for(Element item:linkelements){

            if(item.text().split(" ").length<=8){
                headlineKeywordsList.add(item.text());
            }

        }
        return headlineKeywordsList;
    }

}
