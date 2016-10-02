package com.sionach.ux.csslists;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by drzalek on 02.10.16.
 */
public class PropertiesListsFromCss {

    public List<String> propertiesList(List<String> bracesList){
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
}
