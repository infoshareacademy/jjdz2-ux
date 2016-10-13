package com.sionach.ux.routing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LinkMenagement {

    private final String BASEURL;
    private final String HTMLCODE;
    private List<String> links;
    private List<String> innerLinks;
    private List<String> outerLinks;

    public LinkMenagement(String baseURL, String htmlCode){
        this.BASEURL = baseURL;
        this.HTMLCODE = htmlCode;
        parseLinksFromHtml();
        makeInnerLinks();
        makeOuterLinks();
    }

    public void parseLinksFromHtml(){

        links = new ArrayList<>();
        Document doc = Jsoup.parse(HTMLCODE);
        Elements elements = doc.select("a[href]");

        for(Element element : elements){
            links.add(element.attr("href"));
        }
    }

    public void makeInnerLinks(){
        innerLinks = links.stream()
                .filter(link -> link.contains(BASEURL))
                .collect(Collectors.toList());
    }

    public void makeOuterLinks(){
        outerLinks = links.stream()
                .filter(link -> !link.contains(BASEURL))
                .collect(Collectors.toList());
    }

    public List<String> getLinks() {
        return links;
    }

    public List<String> getInnerLinks() {
        return innerLinks;
    }

    public List<String> getOuterLinks() {
        return outerLinks;
    }
}
