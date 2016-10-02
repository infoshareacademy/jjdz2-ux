package com.sionach.ux.keyWords;


import com.sionach.ux.filemanagment.ReadFiles;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeywordsFromBolded {

    public List<String> boldedKeywords(String htmlCode) {

        String pattern = "(?i)<b [^>]*>[^</]*</b>|<strong[^>]*>[^</]*</strong";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(htmlCode);

        List<String> keywords = new ArrayList<>();

        while (m.find()) {
            keywords.add(m.group().replaceAll("<b[^>]*>|<strong[^>]*>", "").replaceAll("</b|</strong", ""));
        }

        return keywords;


    }

    public static void main(String[] args) {

        KeywordsFromBolded keywordsFromBolded= new KeywordsFromBolded();
        ReadFiles file = new ReadFiles();
        Document doc = Jsoup.parse(file.readFileToString("testowy2.html"));
//        Elements bolded = doc.getElementsByTag();
        Elements bolded = doc.select("strong");
        String test = bolded.text();
        System.out.println(bolded);
        System.out.println(test);

        System.out.println(keywordsFromBolded.boldedKeywords(file.readFileToString("testowy2.html")));
    }
}
