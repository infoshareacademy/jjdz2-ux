package com.sionach.ux.siteAvailability;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allic on 14/10/2016.
 */
public class AltAndTitleInImage {
    public List<String> ImageAltTitle(String htmlCode){
        Document doc = Jsoup.parse(htmlCode);
        Elements elements = doc.select("img");
        System.out.println(elements.toString());
        List<String> altTitleList = new ArrayList<>();

        for(Element item:elements) {
            System.out.println(item.toString());
            if (item.attr("alt").length() > 0) {
                altTitleList.add(item.attr("img"));
                System.out.println("alt found");
            }
            if (item.attr("title").length() > 0) {
                altTitleList.add(item.attr("title"));
                System.out.println("title found");
            }
        }

        return altTitleList;
    }

}
