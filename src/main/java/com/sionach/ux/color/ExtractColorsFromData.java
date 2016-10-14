package com.sionach.ux.color;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by allic on 07/10/2016.
 */
public class ExtractColorsFromData {

    public static List<String> extractHexRgbRgbaColors(List<String> stringListFromCSS) {
        List<String> extractColorsList = new ArrayList<String>();
        String pattern = "(?i)#[0-9a-f]{2,6}|(?i)rgba\\([0-9]{1,3},[0-9]{1,3},[0-9]{1,3},[0-1]{0,3}\\)|(?i)rgb\\([0-9]{1,3},[0-9]{1,3},[0-9]{1,3}\\)";
        Pattern p = Pattern.compile(pattern);
        for (String aStringList : stringListFromCSS) {
            Matcher m = p.matcher(aStringList);
            while (m.find()) {
                String results = m.group();
                extractColorsList.add(results);
            }
        }

        return extractColorsList;
    }

    public static List<String> extractNamesColors(List<String> stringListFromCSS) {
        CreateNamesHexListFromFileTableNamesHex createNamesHexListFromFileTableNamesHex = new CreateNamesHexListFromFileTableNamesHex();
        java.util.List<NamesHexTable> namesHexTableList;
        namesHexTableList = createNamesHexListFromFileTableNamesHex.FileTolist();

        List<String> extractColorsList = new ArrayList<String>();
        for (NamesHexTable aNamesHexTableList : namesHexTableList) {
            String pattern = aNamesHexTableList.getColorName();
            Pattern p = Pattern.compile(pattern);
            for (String aStringList : stringListFromCSS) {
                Matcher m = p.matcher(aStringList);
                while (m.find()) {
                    String results = m.group();
                    extractColorsList.add(results);
                }
            }
        }
        return extractColorsList;
    }

}