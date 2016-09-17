package com.sionach.ux.color;

import java.util.regex.Pattern;

/**
 * Created by Alice on 17.09.2016.
 */
public class NamesHexTable {
    private String colorName;
    private String colorHex;

    NamesHexTable() {
        this.setColorName("White");
        this.setColorHex("ffffff");
    }

    NamesHexTable(String colorName, String colorHex) {
        this.setColorName(colorName);
        this.setColorHex(colorHex);
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public String getColorName() {
        return colorName;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void method1(String line) {
        String patternString = " ";
        Pattern pattern = Pattern.compile(patternString);
        String[] split = pattern.split(line);
        if (split.length == 2) {
            this.colorName = split[0];
            this.colorHex = split[1];
        } else {
            System.out.println("Wrong line input");
        }
    }

    public String toString() {

        return "{color:" + this.colorHex + ", colorName:" + this.colorName  + "}";
    }
}