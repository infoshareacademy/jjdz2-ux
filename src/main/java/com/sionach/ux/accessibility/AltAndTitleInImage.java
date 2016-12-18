package com.sionach.ux.accessibility;

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
    public List<String> ImageAltTitle(String htmlCode) {
        Document doc = Jsoup.parse(htmlCode);
        Elements elements = doc.select("img");

        List<String> altTitleList = new ArrayList<>();

        List<String> imagesWithNoAltOrNoTitle = new ArrayList<>();
        imagesWithNoAltOrNoTitle.add("Lista obrazków które nie posiadają znacznika title lub alt:\n");

        for (Element item : elements) {

            if (item.attr("alt").isEmpty()) {
                imagesWithNoAltOrNoTitle.add(item.attr("src"));
            } else {
                altTitleList.add(item.attr("src"));
            }

            if (item.attr("title").isEmpty()) {
                imagesWithNoAltOrNoTitle.add(item.attr("src"));
            } else {
                altTitleList.add(item.attr("src"));
            }
        }

        if (altTitleList.isEmpty()) {
            System.out.println("Wszystkie obrazki na stornie nie posiadają znacznika title, oraz alt.");
        }

        if (imagesWithNoAltOrNoTitle.isEmpty()) {
            System.out.println("Wszystkie obrazki na stronie prawidłowo posiadają znacznik title, oraz alt");
        }
        return imagesWithNoAltOrNoTitle;
    }

}
