package com.sionach.ux.keyWords;

import com.sionach.ux.filemanagment.ReadFiles;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by webownia on 17.09.16.
 */
public class KeywordsFromAttributes {

    public List<String> attributesKeywords(String htmlCode){
        List<String> attributesKeywordsList = new ArrayList<String>();
        String pattern = "(?i)title=\"[^\"]*\"|alt=\"[^\"]*\""; //wyciagnie wszystkich atryutow alt i title z tagow html
        String splitSentence = " ";
        Pattern p  = Pattern.compile(pattern);
        Matcher m =  p.matcher(htmlCode);

        while(m.find()){
            String results = m.group().replaceAll("(?i)title=\"|alt=\"","").replaceAll("\"","");
            String[] splitWords = results.split(splitSentence);
            if(splitWords.length <= 8){
                attributesKeywordsList.add(results);

            }

        }

        return attributesKeywordsList;

    }

}
