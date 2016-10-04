package com.sionach.ux.routing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class GetLinks {

    public List<String> getlinks(String htmlCode){

        Document doc = Jsoup.parse(htmlCode);
        Elements elements = doc.select("a[href]");
        List<String> links = new ArrayList<>();

        for(Element element : elements){
            links.add(element.attr("href"));
        }

        return links;
    }
}
