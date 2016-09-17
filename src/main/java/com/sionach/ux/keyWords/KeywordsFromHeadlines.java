package com.sionach.ux.keyWords;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by webownia on 15.09.16.
 */
public class KeywordsFromHeadlines {
    private List<String> headlineKeywords = new ArrayList<String>();

    public List<String> getHeadlineKeywords(String htmlCode) {
        String patternHeadline = "<h[1,2,3]{1}[^>]*>[^</]*</h"; //wzór do wyszukiwania headlinów h1,h2,h3
        String splitSentence = " ";
        Pattern p = Pattern.compile(patternHeadline);
        Matcher m = p.matcher(htmlCode);

        while(m.find()){
            String results = m.group().replaceAll("<h[1,2,3]{1}[^>]*>","").replaceAll("</h","");
            String[] splitWords = results.split(splitSentence);
            if(splitWords.length<=8){
                headlineKeywords.add(results);
            }
        }

        return headlineKeywords;
    }
}
