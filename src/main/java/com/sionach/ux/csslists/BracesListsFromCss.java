package com.sionach.ux.csslists;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BracesListsFromCss {

    public List<String> bracesList(String cssString) {
        List<String> bracesList = new ArrayList<String>();
        cssString = cssString.replaceAll("(?i)/\\*[^\\*]*\\*/", ""); //wyczyszczenie kodu z komentarzy blokowych css
        cssString = cssString.replaceAll("(?i)//[^\n]*\n", ""); //wyczyszczenie kodu z komentzry liniowych css
        String patternBraces = "(?i)\\{[^}]*\\}"; //wzór do pobrania kodu pomiędzy klamrami {} i umieszczenie w elementach tablicy

        Pattern p = Pattern.compile(patternBraces);
        Matcher m = p.matcher(cssString);
        while (m.find()) {
            bracesList.add(m.group().replaceAll("\\{{1}", "").replaceAll("\\}{1}", ""));
        }

        return bracesList;
    }

}
