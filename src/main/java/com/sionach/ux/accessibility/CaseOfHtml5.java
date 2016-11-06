package com.sionach.ux.accessibility;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaseOfHtml5 {

    public List<String> CheckIfHtml5(String htmlCode) {
        List<String> html5List = new ArrayList<>();
        Document doc = Jsoup.parse(htmlCode);
        Pattern pattern = Pattern.compile("(?i)<!DOCTYPE html>");
        Matcher m = pattern.matcher(htmlCode);
        if (m.find()) {
            System.out.println("Strona jest napisana w HTML5");
            AttributesFromHtml5(htmlCode, html5List);
        } else {
            System.out.println("Strona nie jest napisana w HTML5");
        }

        return html5List;
    }

    private void AttributesFromHtml5(String htmlCode, List<String> html5List) {
        Document doc = Jsoup.parse(htmlCode);
        Elements section = doc.select("section");
        Elements footer = doc.select("footer");
        Elements header = doc.select("header");
        Elements nav = doc.select("nav");
        Elements article = doc.select("article");

        ArticleCheck(article, html5List);

        if (!section.isEmpty()) {
            html5List.add("section");
            System.out.println("Na stronie występuje znacznik: section");
        } else {
            System.out.println("Na stronie brakuje znacznika: section");
        }

        if (!footer.isEmpty()) {
            html5List.add("footer");
            System.out.println("Na stronie występuje znacznik: footer");
        } else {
            System.out.println("Na stronie brakuje znacznika: footer");
        }

        if (!header.isEmpty()) {
            html5List.add("header");
            System.out.println("Na stronie występuje znacznik: header");
        } else {
            System.out.println("Na stronie brakuje znacznika: header");
        }

        if (!nav.isEmpty()) {
            html5List.add("nav");
            System.out.println("Na stronie występuje znacznik: nav");
        } else {
            System.out.println("Na stronie brakuje znacznika: nav");
        }
    }

    private void ArticleCheck(Elements article, List<String> html5List) {
        int numberOfHeaders = 0;
        int numberOfFooters = 0;
        if (article.isEmpty()) {
            System.out.println("Na stronie brakuje znacznika: article");
        } else {

            for (Element item : article) {
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

        if (numberOfFooters > 1) {
            System.out.println("Na stronie występuje za dużo znaczników footer w sekcji article");
        }
        if (numberOfHeaders > 1) {
            System.out.println("There are to many headers in article section");
        }
    }
}
