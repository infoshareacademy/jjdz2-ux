package com.sionach.ux.color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Alice on 14.09.2016.
 */
public class splitLineTab {

    String[] twoElements = new String[2];

    public String[] getTwoElements() {
        return twoElements;
    }

    public String[] splitting(String line){

        String patternString = " " ;
        Pattern pattern = Pattern.compile(patternString);

        String[] split = pattern.split(line);

        int i=0;
        for (String element: split){
            do {
                this.twoElements[i] = element;
                i++;
            } while(i<2);
        }

        return twoElements;
    }




}
