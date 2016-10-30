package com.sionach.ux.accessibility;

import com.sionach.ux.filemanagment.ReadFiles;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SettingsInHeadElement {

    private String htmlCode;
    private static final String ATTR_TAG_CONTENT = "content";
    private static final String ATTR_TAG_HREF = "href";
    private static final String TAG_META_DESCRIPTION = "meta[name=description]";
    private static final String TAG_META_KEYWORDS = "meta[name=keywords]";
    private static final String TAG_TITLE = "title";
    private static final String TAG_LINK_CANONICAL = "link[rel=canonical]";

    public void setHtmlCode(String htmlCode) {
        this.htmlCode = htmlCode;
    }

    public int checkDescriptionLength(){
        return String.join(" ",new ParseHtmlString().atributesValueFromHtmlTag(htmlCode,TAG_META_DESCRIPTION,ATTR_TAG_CONTENT)).length();
    }

    public int checkNoDescriptionOccurance(){
        return new ParseHtmlString().atributesValueFromHtmlTag(htmlCode,TAG_META_DESCRIPTION,ATTR_TAG_CONTENT).size();
    }

    public int checkMetaKeywordsOccurance(){
        return new ParseHtmlString().atributesValueFromHtmlTag(htmlCode,TAG_META_KEYWORDS,ATTR_TAG_CONTENT).size();
    }

    public int checkTitleLength(){
        return String.join(" ",new ParseHtmlString().tagsTextFromHtml(htmlCode,TAG_TITLE)).length();
    }

    public int checkNoTitleOccurance(){
        return new ParseHtmlString().tagsTextFromHtml(htmlCode,TAG_TITLE).size();
    }

    public boolean checkRelCanonical(){
        String canonical = new ParseHtmlString().atributesValueFromHtmlTag(htmlCode,TAG_LINK_CANONICAL,ATTR_TAG_HREF).toString();
        Pattern pattern = Pattern.compile("(?i)http://.*$");
        Matcher m = pattern.matcher(canonical);
        if(m.find())
            return true;
        else
            return false;
    }

    public int checkNoRelCanonicalOccurance(){
        return new ParseHtmlString().atributesValueFromHtmlTag(htmlCode,TAG_LINK_CANONICAL,ATTR_TAG_HREF).size();
    }

    public static void main(String[] args) {
        ReadFiles file = new ReadFiles("infoshareacademy/index.html");
        String htmlCode = file.readFileToString();
        SettingsInHeadElement sets = new SettingsInHeadElement();
        sets.setHtmlCode(htmlCode);
        System.out.println(sets.checkNoRelCanonicalOccurance());
    }

    public List<String> checkHeadSettings(String htmlCode) {
        List<String> settingsInfo = new ArrayList<>();
        Document doc = Jsoup.parse(htmlCode);
        String description = doc.select("meta[name=description]").attr("content");
        String keywords = doc.select("meta[name=keywords]").attr("content");
        String meta = doc.select("meta[http-equiv=content-type]").attr("content");
        String title = doc.select("title").text();
        String canonical = doc.select("link[rel=canonical]").attr("href");
        String htmlLang = doc.select("html").attr("lang");
        if (description.length() == 0) {
            settingsInfo.add("META description nie zostało ustawione, powinno mieć długość od 150 do 160 znaków");
        } else if (description.length() > 160) {
            settingsInfo.add("META description ma " + description.length() + " znaków i jest zbyt długie, optymalna długość to 150-160 znaków");
        } else if (description.length() < 150) {
            settingsInfo.add("META description ma " + description.length() + " znaków i jest zbyt krótkie, optymalna długość to 150-160 znaków");
        } else {
            settingsInfo.add("META description ma odpowiednią długość");
        }

        if (keywords.length() > 0) {
            settingsInfo.add("Obecnie nie zaleca się ustawiania META keywords dla stron internetowych. Najlepiej usuń META keywords se swojej strony");
        }

        if (title.length() == 0) {
            settingsInfo.add("Tag TITLE nie został podany. Uzupełnij tag Title, pamiętając, że powinien mieć maksymalnie 60 znaków, optymalna długość to 55 znaków");
        } else if (title.length() > 60) {
            settingsInfo.add("Tag TITLE ma " + title.length() + " znaków i jest zbyt długi, optymalna długość to około 55 znaków, maksymalna to 60 znaków");
        } else {
            settingsInfo.add("Tag TITLE ma " + title.length() + " znaków i jest prawidłowo ustawiony. Upewnij się, że liczba znaków w tagu wynosi około 55 i ma nie więcej niż 60");
        }

        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(canonical);

        if (canonical.length() == 0) {
            settingsInfo.add("LINK rel=cannonical nie został ustawiony. Ustaw odpowiedni adres kononiczny dla Twojej witryny");
        } else if (!m.find()) {
            settingsInfo.add("LINK rel=canonical powinien być adresem URL, popraw swój adres kanoniczny dla strony");
        } else {
            settingsInfo.add("LINK rel=canonical jest ustawiony poprwanie");
        }

        regex = "(?i)utf\\-8";
        p = Pattern.compile(regex);
        m = p.matcher(meta);
        if (!m.find()) {
            settingsInfo.add("Zaleca się ustawienie kodowania dokumentu HTML na utf-8");
        } else {
            settingsInfo.add("Twój dokument HTML jest zakodowany prawidłowo w utf-8");
        }

        regex = "(?i)[a-z]{2}\\-[a-z]{2}";
        p = Pattern.compile(regex);
        m = p.matcher(htmlLang);
        if (!m.find()) {
            settingsInfo.add("Zaleca się podanie atrybutu lang w tagu HTML w formacie xx-XX - zgodnie z językiem Twojej strony.");
        } else {
            settingsInfo.add("Twój dokument HTML ma prawidłowy format atrybutu lang");
        }


        return settingsInfo;
    }


}

