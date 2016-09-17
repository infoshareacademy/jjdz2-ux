package com.sionach.ux.keyWords;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by webownia on 17.09.16.
 */
public class KeywordsFromAttributes {
    private List<String> attributesKeywords = new ArrayList<String>();

    public List<String> getAttributesKeywords(String htmlCode){

        String pattern = "(?i)title=\"[^\"]*\"|alt=\"[^\"]*\""; //wyciagnie wszystkich atryutow alt i title z tagow html
        String splitSentence = " ";
        Pattern p  = Pattern.compile(pattern);
        Matcher m =  p.matcher(htmlCode);

        while(m.find()){
            String results = m.group().replaceAll("(?i)title=\"|alt=\"","").replaceAll("\"","");
            String[] splitWords = results.split(splitSentence);
            if(splitWords.length <= 8){
                attributesKeywords.add(results);

            }

        }

        return attributesKeywords;

    }
}
