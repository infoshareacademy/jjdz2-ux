package com.sionach.ux.accessibility;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by webownia on 19.11.16.
 */
public class ParseHtmlUrl {
    public List<String> tagsTextFromHtml(String domainUrl, String tagToParse){
        Document doc = null;
        try {
            doc = Jsoup.connect(domainUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc.select(tagToParse).stream()
                .map(element -> element.text())
                .collect(Collectors.toList());
    }

    public List<String> atributesValueFromHtmlTag(String domainUrl, String htmlTag, String htmlAttribute){
        Document doc = null;
        try {
            doc = Jsoup.connect(domainUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc.select(htmlTag).stream()
                .map(tag -> tag.attr(htmlAttribute))
                .collect(Collectors.toList());
    }

    public boolean CheckHtml5(String domainUrl) {
        String htmlCode = htmlFromUrlToString(domainUrl);
        Pattern pattern = Pattern.compile("(?i)<!DOCTYPE html>");
        Matcher m = pattern.matcher(htmlCode);
        if (m.find()) {
            return true;
        } else {
            return false;
        }

    }

    public String htmlFromUrlToString(String domainUrl){

        Document doc = null;
        try {
            doc = Jsoup.connect(domainUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc.toString();
    }

    public String CheckProtocolInUrl(String domainUrl){
        String domain = domainUrl;
        return domain;
    }
}
