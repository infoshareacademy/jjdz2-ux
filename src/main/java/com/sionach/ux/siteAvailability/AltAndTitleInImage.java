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

        List<String> imagesWithNoAltOrNoTitle = new ArrayList<>();

        for(Element item:elements) {
            System.out.println(item.toString());
            if (item.attr("alt").isEmpty()) {
                imagesWithNoAltOrNoTitle.add(item.attr("src"));
            }
            else {
                altTitleList.add(item.attr("src"));
            }

            if (item.attr("title").isEmpty()) {
                imagesWithNoAltOrNoTitle.add(item.attr("src"));
            }
            else {
                altTitleList.add(item.attr("src"));
            }
        }

        if(altTitleList.isEmpty()) {
            System.out.println("There is no alt nor title in any image");
        }

        return imagesWithNoAltOrNoTitle;
    }

}
