package com.sionach.ux.accessibility;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class HeadlinesInHtml {


    public void setDomainUrl(String domainUrl) {
        this.domainUrl = domainUrl;
    }

    private String domainUrl;
    private static final String TAG_HEADLINE = "h1, h2, h3, h4, h5, h6";
    private static final String TAG_H1 = "h1";


    public int checkNoHeadlinesOccurance(){
        return new ParseHtmlUrl().tagsTextFromHtml(domainUrl,TAG_HEADLINE).size();
    }

    public int checkNoH1Occurance(){
        return new ParseHtmlUrl().tagsTextFromHtml(domainUrl,TAG_H1).size();
    }


}
