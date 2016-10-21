package com.sionach.ux.accessibility;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by drzal on 21.10.2016.
 */
public class LinksInHtml {

    public String checkNumberOfLinks(String htmlCode){
        String linksInfo;
        Document doc = Jsoup.parse(htmlCode);
        Elements hrefs = doc.select("a");
        List<String> linkList = new ArrayList<>();

        for(Element item:hrefs){
            linkList.add(item.attr("href"));
        }
        long numberOfLinks = linkList.stream()
                .filter(line -> line.matches("(?i)^[^#]{1}.*$"))
                .count();

        if(numberOfLinks>100){
            linksInfo = "Liczba linków na Twojej stronie wynosi "+numberOfLinks+" i jest ich zbyt dużo. Zalecana maksymalna liczba linków na stronie to 100";
        }else{
            linksInfo = "Znaleziono "+numberOfLinks+" linków na Twojej stronie. Liczba linków jest mniejsza niż 100, więc jest prawidłowa";
        }
        return linksInfo;
    }

}
