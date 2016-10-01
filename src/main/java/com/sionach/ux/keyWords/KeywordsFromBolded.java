package com.sionach.ux.keyWords;


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
}
