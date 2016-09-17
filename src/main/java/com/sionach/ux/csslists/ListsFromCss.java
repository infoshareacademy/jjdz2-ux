package com.sionach.ux.csslists;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by webownia on 14.09.16.
 */
public class ListsFromCss {

    public List<String> getBracesList(String cssString) {
        List<String> bracesList = new ArrayList<String>();
        String patternBraces = "(?i)\\{[^}]*\\}"; //wzór do pobrania kodu pomiędzy klamrami {} i umieszczenie w elementach tablicy

        Pattern p = Pattern.compile(patternBraces);
        Matcher m = p.matcher(cssString);
        while(m.find()){
            bracesList.add(m.group().replaceAll("\\{{1}","").replaceAll("\\}{1}",""));
        }

        return bracesList;
    }

    public List<String> getPropertiesList(List<String> bracesList){
        List<String> propertiesList = new ArrayList<String>();
        String patternToSplit = ";";

        Pattern pattern = Pattern.compile(patternToSplit);
        for(String item : bracesList){
            String[] propertiesParts = pattern.split(item);

            for(String element : propertiesParts){

                propertiesList.add(element);

            }
        }
        return propertiesList;
    }

    public List<String> getValuesList(List<String> propertiesList){
        List<String> valuesList = new ArrayList<String>();
        String patternToSplit = ":";
        Pattern pattern = Pattern.compile(patternToSplit);

        for(String item : propertiesList){
            String[] valuesParts = pattern.split(item);
            int i = 2;
            for(String element : valuesParts){
                if((i%2)!=0){
                    valuesList.add(element);
                }
                i++;
            }
        }
        return valuesList;
    }

}
