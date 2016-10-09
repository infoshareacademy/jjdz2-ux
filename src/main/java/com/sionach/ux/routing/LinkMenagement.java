package com.sionach.ux.routing;

import com.sionach.ux.filemanagment.ReadFiles;
import org.apache.tools.ant.util.KeepAliveInputStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class LinkMenagement {

    private final String BASEURL;
    private final String HTMLCODE;
    private List<String> links;
    private List<String> innerLinks;
    private List<String> outerLinks;

    public LinkMenagement(String baseURL, String htmlCode){
        this.BASEURL = baseURL;
        this.HTMLCODE = htmlCode;
    }

    public void parseLinksFromHtml(){

        links = new ArrayList<>();
        Document doc = Jsoup.parse(HTMLCODE);
        Elements elements = doc.select("a[href]");

        for(Element element : elements){
            links.add(element.attr("href"));
        }
    }

    public void innerLinks(){
    }

    public void outerLinks(){
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

    public static void main(String[] args) {

        ReadFiles file = new ReadFiles("auto-bloger.html");
        LinkMenagement linkMenagement = new LinkMenagement("auto-bloger.pl", file.readFileToString());
        linkMenagement.parseLinksFromHtml();

        System.out.println(linkMenagement.getLinks());
    }
}
