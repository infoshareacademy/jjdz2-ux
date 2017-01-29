package com.sionach.ux.color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Stateless
public class CssListFromHtml {

    private static final Logger LOGGER = LogManager.getLogger("CssListFromHtml.class");

    public List<String> codeInlineList(String htmlCode) {
        LOGGER.debug("Search for CSS in inline elements of html");
        List<String> codeInlineList = new ArrayList<String>();

        String patternStyle = "(?i)style\\=\"[^\"]*\""; //wzór do pobrania kodu css w tagach html

        Pattern p = Pattern.compile(patternStyle);
        Matcher m = p.matcher(htmlCode);
        while (m.find()) {
            codeInlineList.add(m.group().replaceAll("style\\=\"", "").replaceAll("\"", ""));
            LOGGER.info("CSS found");
        }

        return codeInlineList;
    }

    public List<String> codeHeadList(String htmlCode) {
        LOGGER.debug("Search for CSS in head of html");
        List<String> codeHeadList = new ArrayList<>();
        htmlCode = htmlCode.replaceAll("(?i)/\\*[^\\*]*\\*/", ""); //wyczyszczenie kodu z komentarzy blokowych css
        htmlCode = htmlCode.replaceAll("(?i)//[^\n]*\n", ""); //wyczyszczenie kodu z komentzry liniowych css
        String patternStyle = "(?i)<style[^<]*</style>"; //wzór do pobrania kodu css w tagach style

        Pattern p = Pattern.compile(patternStyle);
        Matcher m = p.matcher(htmlCode);
        while (m.find()) {
            codeHeadList.add(m.group().replaceAll("<style[^>]*>", "").replaceAll("</style>", ""));
            LOGGER.info("CSS found");
        }

        return codeHeadList;
    }
}
