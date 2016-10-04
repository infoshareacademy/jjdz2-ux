package com.sionach.ux.keyWords;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class KeywordsFromBolded {

    public List<String> boldedKeywords(String htmlCode) {

        Document doc = Jsoup.parse(htmlCode);
        Elements elements = doc.select("strong, b");
        List<String> bolded = new ArrayList<>();

        for (Element element : elements) {
            bolded.add(element.text());
        }

        return bolded;
    }
}
