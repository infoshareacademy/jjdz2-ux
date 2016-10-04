package com.sionach.ux.keyWords;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public class KeywordsFromAnchor {
    public List<String> keywordsAnchor(String htmlCode){
        Document doc = Jsoup.parse(htmlCode);
        Elements elements = doc.select("article");
        List<String> articlesList = new ArrayList<>();

        for (Element element : elements) {
            articlesList.add(element.toString());

        }

        String articles = String.join(" ",articlesList);

        List<String> anchor = new ArrayList<>();
        Document linkdoc = Jsoup.parse(articles);
        Elements linkelements = linkdoc.select("a");
        for(Element item:linkelements){

            if(item.text().split(" ").length<=8){
                anchor.add(item.text());
            }

        }
        return anchor;
    }

}
