package com.sionach.ux.routing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class LinkManagement {

    public Document getPageAsDocument(String link) throws IOException {
        Document doc = Jsoup.connect(link).get();
        return doc;
    }

    public List<String> parseLinksFromHtml(Document doc) {

        List<String> links = new ArrayList<>();
        Elements elements = doc.select("a[href]");

        for (Element element : elements) {
            links.add(element.attr("href"));
        }
        return links;
    }

    public List<String> getInnerLinks(List<String> links, String baseUrl) {
        String patternForInnerLinksBaseUrl = "(http[s]?://[w]{0,3}\\.?" + baseUrl + ".*)";
        String patternForInnerLinks = "(?!http[s]?://)";
        return links.stream()
                .filter(link -> link.matches("(?i)^" + patternForInnerLinksBaseUrl + "|" + patternForInnerLinks + ".*$"))
                .collect(Collectors.toList());
    }

    public List<String> getOuterLinks(List<String> links, String baseUrl) {
        String patternForOuterLinks = "(?i)^http[s]?://.*";
        return links.stream()
                .filter(link -> link.matches(patternForOuterLinks))
                .filter(link -> !link.contains(baseUrl))
                .collect(Collectors.toList());
    }
}
