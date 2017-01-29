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


}
