package com.sionach.ux.csslists;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class ValuesListsFromCss {

    public List<String> valuesList(List<String> propertiesList) {
        List<String> valuesList = new ArrayList<String>();
        String patternToSplit = ":";
        Pattern pattern = Pattern.compile(patternToSplit);

        for (String item : propertiesList) {
            String[] valuesParts = pattern.split(item);
            int i = 2;
            for (String element : valuesParts) {
                if ((i % 2) != 0) {
                    valuesList.add(element);
                }
                i++;
            }
        }
        return valuesList;
    }
}
