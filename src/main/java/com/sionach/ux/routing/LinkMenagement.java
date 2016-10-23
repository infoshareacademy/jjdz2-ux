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

    public LinkMenagement(String htmlCode, String baseURL){
        this.BASEURL = baseURL;
        this.HTMLCODE = htmlCode;
        parseLinksFromHtml();
    }

    public void parseLinksFromHtml(){

        links = new ArrayList<>();
        Document doc = Jsoup.parse(HTMLCODE);
        Elements elements = doc.select("a[href]");

        for(Element element : elements){
            links.add(element.attr("href"));
        }
    }

    public List<String> getInnerLinks(){
        String patternForInnerLinksBaseUrl = "(http[s]?://[w]{0,3}\\.?"+BASEURL+".*)";
        String patternForInnerLinks = "(?!http[s]?://)";
        return links.stream()
                .filter(link -> link.matches("(?i)^"+patternForInnerLinksBaseUrl +"|"+ patternForInnerLinks+".*$"))
                .collect(Collectors.toList());
    }

    public List<String> getOuterLinks(){
        String patternForOuterLinks = "(?i)^http[s]?://.*";
        return links.stream()
                .filter(link -> link.matches(patternForOuterLinks))
                .filter(link -> !link.contains(BASEURL))
                .collect(Collectors.toList());
    }

    public List<String> getLinks() {
        return links;
    }

}
