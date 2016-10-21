package com.sionach.ux.accessibility;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by drzal on 21.10.2016.
 */
public class LinksInHtml {

    public String checkNumberOfLinks(String htmlCode){
        String linksInfo="";
        Document doc = Jsoup.parse(htmlCode);
        Elements hrefs = doc.select("href");
        int numberOfHrefs = hrefs.size();

        if(numberOfHrefs>100){
            linksInfo = "Liczba linków na Twojej stronie wynosi "+numberOfHrefs+" i jest ich zbyt dużo. Zalecana maksymalna liczba linków na stronie to 100";
        }else{
            linksInfo = "Znaleziono "+numberOfHrefs+" linków na Twojej stronie. Liczba linków jest mniejsza niż 100, więc jest prawidłowa";
        }


        return linksInfo;
    }

}
