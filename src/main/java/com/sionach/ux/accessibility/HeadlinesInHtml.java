package com.sionach.ux.accessibility;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * Created by webownia on 21.10.16.
 */
public class HeadlinesInHtml {

    public String checkNoOccurrancesH1(String htmlCode){
        String noH1 = "";

        Document doc = Jsoup.parse(htmlCode);
        Elements h1 = doc.select("h1");

        if(h1.size()<1){
            noH1 = "Nagłówek pierwszego rzędu powinien pojawić się na stronie dokładnie raz - dodaj nagłówke h1 do swojej strony";
        }else if(h1.size()>1){
            noH1 = "Nagłówek pierwszego rzędu powinien występować na stronie tylko raz. Pozostaw jeden, najważniejszy nagłówke h1, a pozostałe zamień na nagłówki niższych rzędów";
        }else{
            noH1 = "Nagłówek pierwszego rzędu prawidłowo występuje tylko raz na stronie";
        }
        return noH1;
    }

    public String checkHeadlinesInHtml(String htmlCode){
        String headlinesInfo;
        Document doc = Jsoup.parse(htmlCode);
        Elements headlines = doc.select("h1, h2, h3, h4, h5, h6");
        if(headlines.size()==0){
            headlinesInfo = "Na Twojej stronie nie ma nagłówków. Warto je dodać, nagłówki ułatwiają przeglądanie zawartości witryny i są pomocno przy optymalizacji.";
        }else{
            headlinesInfo = "Twoja strona posiada nagłówki";
        }

        return headlinesInfo;
    }

}
