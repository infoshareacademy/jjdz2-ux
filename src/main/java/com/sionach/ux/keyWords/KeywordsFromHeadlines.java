package com.sionach.ux.keyWords;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by webownia on 15.09.16.
 */
public class KeywordsFromHeadlines {

    public List<String> HeadlineKeywords(String htmlCode) {
        List<String> headlineKeywords = new ArrayList<String>();
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

    public static void main(String[] args) {
        String html = "";
        KeywordsFromHeadlines keywordsResult = new KeywordsFromHeadlines();
        List<String> test = keywordsResult.HeadlineKeywords(html);

        for(String item : test){
            System.out.println(item);
        }
    }
}
