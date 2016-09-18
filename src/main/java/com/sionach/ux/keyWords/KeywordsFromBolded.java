package com.sionach.ux.keyWords;


import com.sionach.ux.filemanagment.ReadFiles;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeywordsFromBolded {

    public List<String> boldedKeywords(String htmlCode){

        String pattern = "<b[^>]*>[^</]*</b|<strong[^>]*>[^</]*</strong";
        Pattern p  = Pattern.compile(pattern);
        Matcher m =  p.matcher(htmlCode);

        List<String> keywords = new ArrayList<>();

        while(m.find()){
            keywords.add(m.group().replaceAll("<b[^>]*>|<strong[^>]*>", "").replaceAll("</b|</strong", "").replaceAll("[^A-Za-z0-9]", " "));

        }

        return keywords;
    }

    public static void main(String[] args) {

        KeywordsFromBolded keywordsFromBolded = new KeywordsFromBolded();
        ReadFiles readFiles = new ReadFiles();

        System.out.println(keywordsFromBolded.boldedKeywords(readFiles.readFileToString("testowy.html")));
    }
}
