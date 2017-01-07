package com.sionach.ux.accessibility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SettingsInHeadElement {

    public void setDomainAddress(String domainAddress) {
        this.domainAddress = domainAddress;
    }

    private String domainAddress;
    private static final String ATTR_TAG_CONTENT = "content";
    private static final String ATTR_TAG_HREF = "href";
    private static final String TAG_META_DESCRIPTION = "meta[name=description]";
    private static final String TAG_META_KEYWORDS = "meta[name=keywords]";
    private static final String TAG_TITLE = "title";
    private static final String TAG_LINK_CANONICAL = "link[rel=canonical]";
    private static final String TAG_HTML = "html";
    private static final String ATTR_TAG_LANG = "lang";




    public int checkDescriptionLength(){
        return String.join(" ",new ParseHtmlUrl().atributesValueFromHtmlTag(domainAddress,TAG_META_DESCRIPTION,ATTR_TAG_CONTENT)).length();
    }

    public int checkNoDescriptionOccurance(){
        return new ParseHtmlUrl().atributesValueFromHtmlTag(domainAddress,TAG_META_DESCRIPTION,ATTR_TAG_CONTENT).size();
    }

    public int checkMetaKeywordsOccurance(){
        return new ParseHtmlUrl().atributesValueFromHtmlTag(domainAddress,TAG_META_KEYWORDS,ATTR_TAG_CONTENT).size();
    }

    public int checkTitleLength(){
        return String.join(" ",new ParseHtmlUrl().tagsTextFromHtml(domainAddress,TAG_TITLE)).length();
    }

    public int checkNoTitleOccurance(){
        return new ParseHtmlUrl().tagsTextFromHtml(domainAddress,TAG_TITLE).size();
    }

    public boolean checkRelCanonical(){
        String canonical = new ParseHtmlUrl().atributesValueFromHtmlTag(domainAddress,TAG_LINK_CANONICAL,ATTR_TAG_HREF).toString();
        Pattern pattern = Pattern.compile("(?i)http://.*$");
        Matcher m = pattern.matcher(canonical);
        if(m.find())
            return true;
        else
            return false;
    }

    public int checkNoRelCanonicalOccurance(){
        return new ParseHtmlUrl().atributesValueFromHtmlTag(domainAddress,TAG_LINK_CANONICAL,ATTR_TAG_HREF).size();
    }

    //meta charset

    public boolean checkHtmlLang(){
        String lang = new ParseHtmlUrl().atributesValueFromHtmlTag(domainAddress,TAG_HTML,ATTR_TAG_LANG).toString().replaceAll("\\[*\\]*","");
        System.out.println(lang);
        Pattern pattern = Pattern.compile("(?i)^[a-z]{2}\\-[a-z]{2}$");
        Matcher m = pattern.matcher(lang);
        Pattern patternShort = Pattern.compile("(?i)^[a-z]{2,3}$");
        Matcher mShort = patternShort.matcher(lang);
        if(m.find() || mShort.find())
            return true;
        else
            return false;
    }


}

