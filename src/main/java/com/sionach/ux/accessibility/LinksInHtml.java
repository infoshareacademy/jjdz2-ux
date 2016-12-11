package com.sionach.ux.accessibility;


import com.sionach.ux.filemanagment.ReadFiles;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;


public class LinksInHtml {

    public void setDomainUrl(String domainUrl) {
        this.domainUrl = domainUrl;
    }

    private String domainUrl;
    private static final String LINK_TAG = "a";
    private static final String LINK_ATTR = "href";

    public long noOfLinksInHtml(){
        ParseHtmlUrl html = new ParseHtmlUrl();
        return html.atributesValueFromHtmlTag(domainUrl, LINK_TAG, LINK_ATTR).stream()
                .filter(tag -> tag.matches("(?i)^[^#]{1}.*$"))
                .filter(tag -> tag.matches("[^\\(]*"))
                .count();
    }


//    public static void main(String[] args) {
//        ReadFiles file = new ReadFiles();
//        String htmlCode = file.readFileToString("infoshareacademy/index.html");
//        LinksInHtml links = new LinksInHtml();
//        System.out.println(links.noOfLinksInHtml(htmlCode));
//    }

    //stare do usuniecia
    public String checkNumberOfLinks(String htmlCode) {
        String linksInfo;
        Document doc = Jsoup.parse(htmlCode);
        Elements hrefs = doc.select("a");
        List<String> linkList = new ArrayList<>();

        for (Element item : hrefs) {
            linkList.add(item.attr("href"));
        }
        long numberOfLinks = linkList.stream()
                .filter(line -> line.matches("(?i)^[^#]{1}.*$"))
                .filter(line -> line.matches("[^\\(]*"))
                .count();

        if (numberOfLinks > 100) {
            linksInfo = "Liczba linków na Twojej stronie wynosi " + numberOfLinks + " i jest ich zbyt dużo. Zalecana maksymalna liczba linków na stronie to 100";
        } else {
            linksInfo = "Znaleziono " + numberOfLinks + " linków na Twojej stronie. Liczba linków jest mniejsza niż 100, więc jest prawidłowa";
        }
        return linksInfo;
    }

}
