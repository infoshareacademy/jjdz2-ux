package com.sionach.ux.accessibility;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SettingsInHeadElement {

    public List<String> checkHeadSettings(String htmlCode){
        List<String> settingsInfo = new ArrayList<>();
        Document doc = Jsoup.parse(htmlCode);
        String description = doc.select("meta[name=description]").attr("content");
        String keywords = doc.select("meta[name=keywords]").attr("content");
        String meta = doc.select("meta[http-equiv=content-type]").attr("content");
        String title = doc.select("title").text();
        String canonical = doc.select("link[rel=canonical]").attr("href");
        String htmlLang = doc.select("html").attr("lang");
        if(description.length()==0){
            settingsInfo.add("META description nie zostało ustawione, powinno mieć długość od 150 do 160 znaków");
        }else if(description.length()>160){
            settingsInfo.add("META description ma "+description.length()+" znaków i jest zbyt długie, optymalna długość to 150-160 znaków");
        }else if(description.length()<150){
            settingsInfo.add("META description ma "+description.length()+" znaków i jest zbyt krótkie, optymalna długość to 150-160 znaków");
        }else{
            settingsInfo.add("META description ma odpowiednią długość");
        }

        if(keywords.length()>0){
            settingsInfo.add("Obecnie nie zaleca się ustawiania META keywords dla stron internetowych. Najlepiej usuń META keywords se swojej strony");
        }

        if(title.length()==0){
            settingsInfo.add("Tag TITLE nie został podany. Uzupełnij tag Title, pamiętając, że powinien mieć maksymalnie 60 znaków, optymalna długość to 55 znaków");
        }else if (title.length()>60){
            settingsInfo.add("Tag TITLE ma "+title.length()+" znaków i jest zbyt długi, optymalna długość to około 55 znaków, maksymalna to 60 znaków");
        }else{
            settingsInfo.add("Tag TITLE ma "+title.length()+" znaków i jest prawidłowo ustawiony. Upewnij się, że liczba znaków w tagu wynosi około 55 i ma nie więcej niż 60");
        }

        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern p  = Pattern.compile(regex);
        Matcher m = p.matcher(canonical);

        if(canonical.length()==0){
            settingsInfo.add("LINK rel=cannonical nie został ustawiony. Ustaw odpowiedni adres kononiczny dla Twojej witryny");
        }else if(!m.find()){
            settingsInfo.add("LINK rel=canonical powinien być adresem URL, popraw swój adres kanoniczny dla strony");
        }else{
            settingsInfo.add("LINK rel=canonical jest ustawiony poprwanie");
        }

        regex = "utf\\-8";
        p = Pattern.compile(regex);
        m = p.matcher(meta);
        if(!m.find()){
            settingsInfo.add("Zaleca się ustawienie kodowania dokumentu HTML na utf-8");
        }else{
            settingsInfo.add("Twój dokument HTML jest zakodowany prawidłowo w utf-8");
        }

        regex = "(?i)[a-z]{2}\\-[a-z]{2}";
        p = Pattern.compile(regex);
        m = p.matcher(htmlLang);
        if(!m.find()){
            settingsInfo.add("Zaleca się podanie atrybutu lang w tagu HTML w formacie xx-XX - zgodnie z językiem Twojej strony.");
        }else{
            settingsInfo.add("Twój dokument HTML ma prawidłowy format atrybutu lang");
        }


        return settingsInfo;
    }
}

