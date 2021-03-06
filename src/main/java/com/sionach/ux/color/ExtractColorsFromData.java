package com.sionach.ux.color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by allic on 07/10/2016.
 */
public class ExtractColorsFromData {

    private static final Logger LOGGER = LogManager.getLogger(ExtractColorsFromData.class);

    public static List<String> extractHexRgbRgbaColors(List<String> stringListFromCSS) {
        LOGGER.debug("Extracts hex, rgb and rgba colors from data");
        String pattern = "(?i)#[0-9a-f]{2,6}|(?i)rgba\\([0-9]{1,3},[0-9]{1,3},[0-9]{1,3},[0-1]{0,3}\\)|(?i)rgb\\([0-9]{1,3},[0-9]{1,3},[0-9]{1,3}\\)";
        Pattern p = Pattern.compile(pattern);
        List<String> extractColorsList = new ArrayList<>();
        return extractColors(stringListFromCSS,p,extractColorsList);
    }

    public static List<String> extractNamesColors(List<String> stringListFromCSS) {
        LOGGER.debug("Extracts color names from data");
        CreateNamesHexListFromFile createNamesHexListFromFile = new CreateNamesHexListFromFile();
        List<NamesHexTable> namesHexTableList;
        namesHexTableList = createNamesHexListFromFile.fileToStringList();

        List<String> extractColorsList = new ArrayList<>();
        for (NamesHexTable aNamesHexTableList : namesHexTableList) {
            String pattern = aNamesHexTableList.getColorName();
            Pattern p = Pattern.compile(pattern);
            extractColors(stringListFromCSS,p,extractColorsList);
        }
        return extractColorsList;
    }

    private static List<String> extractColors(List<String> stringListFromCSS, Pattern p, List<String> extractColorsList){
        for (String aStringList : stringListFromCSS) {
            Matcher m = p.matcher(aStringList);
            while (m.find()) {
                String results = m.group();
                LOGGER.debug("Color found" + results);
                extractColorsList.add(results);
            }
        }
        return extractColorsList;
    }

}

