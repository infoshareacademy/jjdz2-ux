package com.sionach.ux.siteAvailability;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allic on 14/10/2016.
 */
public class CaseOfHtml5 {

    public List<String> CheckIfHtml5(String htmlCode){
        Document doc = Jsoup.parse(htmlCode);
        Elements doctype = doc.select("!DOCTYPE html");
        List<String> html5List = new ArrayList<>();

        if (doctype.isEmpty()){
            System.out.println("This document is not HTML5");
        }
        else {AttributesFromHtml5(htmlCode,html5List);}

        return html5List;
    }

    private void AttributesFromHtml5(String htmlCode, List<String> html5List){
        Document doc = Jsoup.parse(htmlCode);
        Elements elements = doc.select("html");

        for(Element item:elements) {
            if (item.attr("section").length() > 0) {
                html5List.add(item.attr("charset"));
            }

            if (item.attr("header").length() > 0) {
                html5List.add(item.attr("charset"));
            }

            if (item.attr("footer").length() > 0) {
                html5List.add(item.attr("charset"));
            }

            if (item.attr("nav").length() > 0) {
                html5List.add(item.attr("charset"));
            }

            if (item.attr("article").length() > 0) {
                html5List.add(item.attr("article"));
                CheckIfArticle(elements,html5List);
            }
        }

    }

    private void CheckIfArticle(Elements elements, List<String> html5List){
        Elements articles = elements.select("article");
        int numberOfHeaders = 0;
        int numberOfFooters = 0;

        if (articles.isEmpty()){
            System.out.println("There is no article tags in this HTML5 document");
        }
        else {
            for (Element item : articles) {
                if (item.attr("header").length() > 0) {
                        html5List.add(item.attr("header"));
                        numberOfHeaders++;
                }
                if (item.attr("footer").length() > 0) {
                        html5List.add(item.attr("footer"));
                        numberOfFooters++;
                }
            }
        }

        if (numberOfFooters != 1) {
            System.out.println("There are to many footers in article section");
        }
        if (numberOfHeaders != 1) {
            System.out.println("There are to many headers in article section");
        }
    }

}
