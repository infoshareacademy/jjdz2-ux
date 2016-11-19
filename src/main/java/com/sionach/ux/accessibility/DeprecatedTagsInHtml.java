package com.sionach.ux.accessibility;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.ejb.Stateless;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Stateless
public class DeprecatedTagsInHtml {
    final static String DEPRECATED_FILE = "target/classes/deprecatedTags.txt";

    public List<String> deprecatedHtmlTagsList(String htmlCode) throws FileNotFoundException {
        List<String> deprecatedTags = new ArrayList<>();
        DeprecatedTagsList deprecatedHtmlTags = new DeprecatedTagsList();
        List<String> allDeprecatedTags = deprecatedHtmlTags.createDeprecatedTagsList(DEPRECATED_FILE);
        ParseHtmlUrl html = new ParseHtmlUrl();
        if(html.CheckHtml5(htmlCode)){
           deprecatedTags = allDeprecatedTags.stream()
                    .filter(tag -> html.tagsTextFromHtml(htmlCode, tag).size()>0)
                    .collect(Collectors.toList());
        }
        return deprecatedTags;

    }

//do testowania
    public static void main(String[] args) throws FileNotFoundException {
        String htmlCode = "<!DOCTYPE html><html><head></head><body><p>Tutaj jest jakis tekst z elementami zdeprecjonowanymi w <strike>kodzie html</strike>, to jest <u>test</u></p></body></htmL";
        DeprecatedTagsInHtml tags = new DeprecatedTagsInHtml();
        for(String item:tags.deprecatedHtmlTagsList(htmlCode)){
            System.out.println(item);
        }
    }
//stary kod do usuniecia
    public List<String> findDeprecatedTags(String htmlCode) throws FileNotFoundException {
        List<String> deprecatedTags = new ArrayList<>();
        Pattern pattern = Pattern.compile("(?i)<!DOCTYPE html>");
        Matcher m = pattern.matcher(htmlCode);
        if (m.find()) {
            Document doc = Jsoup.parse(htmlCode);
            DeprecatedTagsList deprecatedHtmlTags = new DeprecatedTagsList();
            List<String> deprecatedTagsList = deprecatedHtmlTags.createDeprecatedTagsList("src/main/resources/deprecatedTags.txt");
            for (String item : deprecatedTagsList) {
                Elements elements = doc.select(item);
                if (elements.size() > 0) {
                    deprecatedTags.add("Tag: <" + item + "> nie jest używany w HTML5");
                }
            }
            if (deprecatedTags.size() == 0) {
                deprecatedTags.add("Dokument nie zawiera zdeprecjonowanych elementów");
            }
        } else {
            deprecatedTags.add("Przesłany dokument nie jest zadeklarowany jako dokument HTML5");

        }
        return deprecatedTags;
    }


}
