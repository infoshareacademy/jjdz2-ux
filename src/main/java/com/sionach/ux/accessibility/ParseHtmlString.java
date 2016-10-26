package com.sionach.ux.accessibility;

import com.sionach.ux.filemanagment.ReadFiles;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class ParseHtmlString {

    public List<String> tagsTextFromHtml(String htmlCode, String tagToParse){
        Document doc = Jsoup.parse(htmlCode);
        return doc.select(tagToParse).stream()
                .map(element -> element.text())
                .collect(Collectors.toList());
    }

    public List<String> atributesValueFromHtmlTag(String htmlCode, String htmlTag, String htmlAttribute){
        Document doc = Jsoup.parse(htmlCode);
        return doc.select(htmlTag).stream()
                .map(tag -> tag.attr(htmlAttribute))
                .collect(Collectors.toList());
    }

    public boolean CheckHtml5(String htmlCode) {
        Pattern pattern = Pattern.compile("(?i)<!DOCTYPE html>");
        Matcher m = pattern.matcher(htmlCode);
        if (m.find()) {
           return true;
        } else {
           return false;
        }

    }



    public static void main(String[] args) {
        ReadFiles file = new ReadFiles("wmh/index.html");
        String htmlCode = file.readFileToString();

        ParseHtmlString html = new ParseHtmlString();
        List<String> list = html.atributesValueFromHtmlTag(htmlCode, "a", "href");
        for(String item:list){
            System.out.println(item);
        }
    }

}
