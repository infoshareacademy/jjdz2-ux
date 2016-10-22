package com.sionach.ux.accessibility;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DeprecatedTagsInHtml {

    public List<String> findDeprecatedTags(String htmlCode) throws FileNotFoundException {
        List<String> deprecatedTags = new ArrayList<>();
        Pattern pattern = Pattern.compile("(?i)<!DOCTYPE html>");
        Matcher m = pattern.matcher(htmlCode);
        if(m.find()){
            Document doc = Jsoup.parse(htmlCode);
            DeprecatedTagsList deprecatedHtmlTags = new DeprecatedTagsList();
            List<String> deprecatedTagsList = deprecatedHtmlTags.createDeprecatedTagsList("src/main/resources/deprecatedTags.txt");
            for(String item:deprecatedTagsList) {
                Elements elements = doc.select(item);
                if(elements.size()>0){
                    deprecatedTags.add("Tag: <"+item+"> nie jest używany w HTML5");
                }
            }
            if(deprecatedTags.size()==0){
                deprecatedTags.add("Dokument nie zawiera zdeprecjonowanych elementów");
            }
        }else{
            deprecatedTags.add("Przesłany dokument nie jest zadeklarowany jako dokument HTML5");

        }
        return  deprecatedTags;
    }


}
