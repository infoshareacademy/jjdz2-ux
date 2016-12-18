package com.sionach.ux.accessibility;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.ejb.Stateless;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Stateless
public class DeprecatedTagsInHtml {
    private final static String DEPRECATED_FILE = "deprecatedTags.txt";

    public void setDomainUrl(String domainUrl) {
        this.domainUrl = domainUrl;
    }

    private String domainUrl;
    public List<String> deprecatedHtmlTagsList() throws FileNotFoundException {
        List<String> deprecatedTags = new ArrayList<>();

        ParseHtmlUrl html = new ParseHtmlUrl();
        if(html.CheckHtml5(domainUrl)){
           deprecatedTags = EnumSet.allOf(DeprecatedTags.class)
                   .stream()
                   .map(tag -> tag.toString())
                   .filter(tag -> html.tagsTextFromHtml(domainUrl, tag).size()>0)
                   .collect(Collectors.toList());
        }
        return deprecatedTags;

    }





}
