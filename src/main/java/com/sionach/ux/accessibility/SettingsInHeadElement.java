package com.sionach.ux.accessibility;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Stateless
public class SettingsInHeadElement {

    private String domainUrl;
    private static final String ATTR_TAG_CONTENT = "content";
    private static final String ATTR_TAG_HREF = "href";
    private static final String TAG_META_DESCRIPTION = "meta[name=description]";
    private static final String TAG_META_KEYWORDS = "meta[name=keywords]";
    private static final String TAG_TITLE = "title";
    private static final String TAG_LINK_CANONICAL = "link[rel=canonical]";
    private static final String TAG_HTML = "html";
    private static final String ATTR_TAG_LANG = "lang";

    public void setDomainUrl(String domainUrl) {
        this.domainUrl = domainUrl;
    }


    public int checkDescriptionLength(){
        return String.join(" ",new ParseHtmlUrl().atributesValueFromHtmlTag(domainUrl,TAG_META_DESCRIPTION,ATTR_TAG_CONTENT)).length();
    }

    public int checkNoDescriptionOccurance(){
        return new ParseHtmlUrl().atributesValueFromHtmlTag(domainUrl,TAG_META_DESCRIPTION,ATTR_TAG_CONTENT).size();
    }

    public int checkMetaKeywordsOccurance(){
        return new ParseHtmlUrl().atributesValueFromHtmlTag(domainUrl,TAG_META_KEYWORDS,ATTR_TAG_CONTENT).size();
    }

    public int checkTitleLength(){
        return String.join(" ",new ParseHtmlUrl().tagsTextFromHtml(domainUrl,TAG_TITLE)).length();
    }

    public int checkNoTitleOccurance(){
        return new ParseHtmlUrl().tagsTextFromHtml(domainUrl,TAG_TITLE).size();
    }

    public boolean checkRelCanonical(){
        String canonical = new ParseHtmlUrl().atributesValueFromHtmlTag(domainUrl,TAG_LINK_CANONICAL,ATTR_TAG_HREF).toString();
        Pattern pattern = Pattern.compile("(?i)http://.*$");
        Matcher m = pattern.matcher(canonical);
        if(m.find())
            return true;
        else
            return false;
    }

    public int checkNoRelCanonicalOccurance(){
        return new ParseHtmlUrl().atributesValueFromHtmlTag(domainUrl,TAG_LINK_CANONICAL,ATTR_TAG_HREF).size();
    }

    //meta charset

    public boolean checkHtmlLang(){
        String lang = new ParseHtmlUrl().atributesValueFromHtmlTag(domainUrl,TAG_HTML,ATTR_TAG_LANG).toString().replaceAll("\\[*\\]*","");
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

//    public static void main(String[] args) {
//
//        String htmlCode = "https://www.wikipedia.org/";
//        SettingsInHeadElement sets = new SettingsInHeadElement();
//        sets.setDomainUrl(htmlCode);
//        System.out.println(sets.checkHtmlLang());
//    }
//
//    public List<String> checkHeadSettings(String htmlCode) {
//        List<String> settingsInfo = new ArrayList<>();
//        Document doc = Jsoup.parse(htmlCode);
//        String description = doc.select("meta[name=description]").attr("content");
//        String keywords = doc.select("meta[name=keywords]").attr("content");
//        String meta = doc.select("meta[http-equiv=content-type]").attr("content");
//        String title = doc.select("title").text();
//        String canonical = doc.select("link[rel=canonical]").attr("href");
//        String htmlLang = doc.select("html").attr("lang");
//        if (description.length() == 0) {
//            settingsInfo.add("META description nie zostało ustawione, powinno mieć długość od 150 do 160 znaków");
//        } else if (description.length() > 160) {
//            settingsInfo.add("META description ma " + description.length() + " znaków i jest zbyt długie, optymalna długość to 150-160 znaków");
//        } else if (description.length() < 150) {
//            settingsInfo.add("META description ma " + description.length() + " znaków i jest zbyt krótkie, optymalna długość to 150-160 znaków");
//        } else {
//            settingsInfo.add("META description ma odpowiednią długość");
//        }
//
//        if (keywords.length() > 0) {
//            settingsInfo.add("Obecnie nie zaleca się ustawiania META keywords dla stron internetowych. Najlepiej usuń META keywords se swojej strony");
//        }
//
//        if (title.length() == 0) {
//            settingsInfo.add("Tag TITLE nie został podany. Uzupełnij tag Title, pamiętając, że powinien mieć maksymalnie 60 znaków, optymalna długość to 55 znaków");
//        } else if (title.length() > 60) {
//            settingsInfo.add("Tag TITLE ma " + title.length() + " znaków i jest zbyt długi, optymalna długość to około 55 znaków, maksymalna to 60 znaków");
//        } else {
//            settingsInfo.add("Tag TITLE ma " + title.length() + " znaków i jest prawidłowo ustawiony. Upewnij się, że liczba znaków w tagu wynosi około 55 i ma nie więcej niż 60");
//        }
//
//        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
//        Pattern p = Pattern.compile(regex);
//        Matcher m = p.matcher(canonical);
//
//        if (canonical.length() == 0) {
//            settingsInfo.add("LINK rel=cannonical nie został ustawiony. Ustaw odpowiedni adres kononiczny dla Twojej witryny");
//        } else if (!m.find()) {
//            settingsInfo.add("LINK rel=canonical powinien być adresem URL, popraw swój adres kanoniczny dla strony");
//        } else {
//            settingsInfo.add("LINK rel=canonical jest ustawiony poprwanie");
//        }
//
//        regex = "(?i)utf\\-8";
//        p = Pattern.compile(regex);
//        m = p.matcher(meta);
//        if (!m.find()) {
//            settingsInfo.add("Zaleca się ustawienie kodowania dokumentu HTML na utf-8");
//        } else {
//            settingsInfo.add("Twój dokument HTML jest zakodowany prawidłowo w utf-8");
//        }
//
//        regex = "(?i)[a-z]{2}\\-[a-z]{2}";
//        p = Pattern.compile(regex);
//        m = p.matcher(htmlLang);
//        if (!m.find()) {
//            settingsInfo.add("Zaleca się podanie atrybutu lang w tagu HTML w formacie xx-XX - zgodnie z językiem Twojej strony.");
//        } else {
//            settingsInfo.add("Twój dokument HTML ma prawidłowy format atrybutu lang");
//        }
//
//
//        return settingsInfo;
//    }


}

