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
        Elements elements = doc.select("body");
        List<String> altTitleList = new ArrayList<>();

        for(Element item:elements) {
            if (item.attr("article").length() > 0) {
                altTitleList.add(item.attr("article"));
                AltTitleInImage(item, altTitleList);
            }
        }

        return altTitleList;
    }

    private void AltTitleInImage(Element item, List<String> altTitleList){
        if (item.hasAttr("alt")){
            altTitleList.add(item.attr("alt"));
        } else {
            System.out.println("There is no alternative for this image");
        }

        if (item.hasAttr("title")){
            altTitleList.add(item.attr("title"));
        } else {
            System.out.println("The image has no title");
        }
    }


}
