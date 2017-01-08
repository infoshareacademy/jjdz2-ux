package com.sionach.ux.color;

import com.sionach.ux.accessibility.ParseHtmlUrl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by allic on 20/12/2016.
 */
public class CssFromHtmlUrl {

    public List<String> GetTotalCssListFromUrl(String domainUrl) {
        List<String> totalList = new ArrayList<>();

        totalList.addAll(FindCssFromUrl(domainUrl));

        List<String> linkList = FindCssLinkInHTML(domainUrl);
        List<String> cssFromExternalCSSLink = GetCssListFromLink(linkList);

        totalList.addAll(cssFromExternalCSSLink);

        return totalList;
    }

    private List<String> FindCssFromUrl(String domainUrl) {
        Document doc = ReadDocument(domainUrl);
        String docString = doc.toString();
        CssListFromHtml csslistFromHtml = new CssListFromHtml();

        List<String> listHead = csslistFromHtml.codeHeadList(docString);
        List<String> listInline = csslistFromHtml.codeInlineList(docString);

        List<String> newList = new ArrayList<>(listHead);
        newList.addAll(listInline);

        return newList;
    }

    private List<String> GetCssListFromLink(List<String> linkList) {
        List<String> listFromLink = new ArrayList<>();
        try {
            for (String s : linkList) {
                listFromLink.addAll(FindCssFromUrl(s));
            }

        } catch (Exception e) {
            System.out.println("Some invalid link found");
        }
        return listFromLink;
    }

//    private List<String> FindCssLinkInHTML(String domainUrl){
//        List<String> cssList = new ArrayList<>();
//        ParseHtmlUrl htmlDoc = new ParseHtmlUrl();
//        cssList = htmlDoc.atributesValueFromHtmlTag(domainUrl,"link","href");
//
//        List<String> newList = new ArrayList<>();
//        String patternHead = "(?i).*\\.css$";
//        Pattern p1 = Pattern.compile(patternHead);
//        for (String s : cssList){
//            Matcher m1 = p1.matcher(s);
//            while (m1.find()){
//                newList.add(m1.group());
//            }
//        }
//
//        return newList;
//    }


//    private List<String> FindCssLinkInHTML(String domainUrl){
//        Document doc = ReadDocument(domainUrl);
//        String docString =doc.toString();
//
//        List<String> headList = new ArrayList<>();
//
//        String patternHead = "(?i)<head[^<]*</head>";
//        Pattern p1 = Pattern.compile(patternHead);
//        Matcher m1 = p1.matcher(docString);
//        while (m1.find()){
//            headList.add(m1.group());
//        }
//
//        String headString = headList.toString();
//
//        List<String> cssList = new ArrayList<>();
//
//        String patternCSS = "(?i)[0-9 a-z]{0,100}\\.css";
//        Pattern p = Pattern.compile(patternCSS);
//        Matcher m = p.matcher(headString);
//        while (m.find()) {
//            cssList.add(m.group().replaceAll("style\\=\"", "").replaceAll("\"", ""));
//        }
//
//        return cssList;
//    }

//        private List<String> FindCssLinkInHTML(String domainUrl){
//            List<String> cssList = new ArrayList<>();
//            ParseHtmlUrl htmlDoc = new ParseHtmlUrl();
//            cssList = htmlDoc.atributesValueFromHtmlTag(domainUrl, "link", "href");
//
//            List<String> newList = new ArrayList<>();
//            String patternHead = "http:(?i).*\\.css$";
//            Pattern p1 = Pattern.compile(patternHead);
//            Pattern p2 = Pattern.compile(domainUrl);
//            Pattern p3 = Pattern.compile("^//.*");
//            for (String s : cssList) {
//                Matcher m1 = p1.matcher(s);
//                if (m1.find()) {
//                    Matcher m2 = p2.matcher(s);
//                    Matcher m3 = p3.matcher(s);
//                    if (m2.find() || m3.find()) {
//                        newList.add(m1.group());
//                    } else {
//                        newList.add(domainUrl + m1.group());
//                    }
//
//                }
//            }
//            return newList;
//        }

    private List<String> FindCssLinkInHTML(String domainUrl){
        List<String> cssList = new ArrayList<>();
        ParseHtmlUrl htmlDoc = new ParseHtmlUrl();
        cssList = htmlDoc.atributesValueFromHtmlTag(domainUrl, "link", "href");

        List<String> newList = new ArrayList<>();
        String patternHead = "http:(?i).*\\.css$";
        Pattern p1 = Pattern.compile(patternHead);
        Pattern p2 = Pattern.compile(domainUrl);
        Pattern p3 = Pattern.compile("^//.*");
        for (String s : cssList) {
            Matcher m1 = p1.matcher(s);
            if (m1.find()) {
                Matcher m2 = p2.matcher(s);
                Matcher m3 = p3.matcher(s);
                if (m2.find()) {
                    newList.add(m1.group());
                }else if(m3.find()){

                } else {
                    newList.add(domainUrl + m1.group());
                }

            }
        }
        return newList;
    }

    private Document ReadDocument(String domainUrl) {
        Document doc = null;
        try {
            doc = Jsoup.connect(domainUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

}
