package com.sionach.ux.color;

import java.awt.*;

public class ConvertColorToHex {
    private String colorHex;  // format #rrggbb

    public ConvertColorToHex(){

        this.colorHex = "#000000";
    }

    public void checkColorFormatAndConvert(String stringColor) {
        if (stringColor.matches("(?i)#[0-9a-f]{2,6}")) {
            if (stringColor.length() == 7) {
                this.colorHex = stringColor;
            } else {
                shortHexToHex(stringColor);
            }
        } else if (stringColor.matches("(?i)rgba\\([0-9]{1,3},[0-9]{1,3},[0-9]{1,3},[0-1]{0,3}\\)")) {
            stringColor = stringColor.replaceAll("\\(", " ");
            stringColor = stringColor.replaceAll("\\)", " ");
            stringColor = stringColor.replaceAll("rgba"," ");
            stringColor = stringColor.trim();
            String[] split = stringColor.split(",", 4);
            int r = Integer.valueOf(split[0]);
            int g = Integer.valueOf(split[1]);
            int b = Integer.valueOf(split[2]);
            int a = Integer.valueOf(split[3]);
            rgbaToHex(r, g, b, a);

        } else if (stringColor.matches("(?i)rgb\\([0-9]{1,3},[0-9]{1,3},[0-9]{1,3}\\)")) {
            stringColor = stringColor.replaceAll("\\(", " ");
            stringColor = stringColor.replaceAll("\\)", " ");
            stringColor = stringColor.replaceAll("rgb"," ");
            stringColor = stringColor.trim();
            String[] split = stringColor.split(",", 3);
            int r = Integer.valueOf(split[0]);
            int g = Integer.valueOf(split[1]);
            int b = Integer.valueOf(split[2]);
            rgbToHex(r, g, b);

        } else {
            nameToHex(stringColor);
        }
    }
    public void setColorHex(String colorHex) {

        this.colorHex = colorHex;
    }

    public String getColorHex() {

        return this.colorHex;
    }

    public void rgbToHex(int r, int g, int b) {
        Color color = new Color(r, g, b);
        String hex = Integer.toHexString(color.getRGB() & 0xffffff);
        while (hex.length() < 6) {
            hex = "0" + hex;
        }
        this.colorHex = "#" + hex;
    }

    public void rgbaToHex(int r, int g, int b, int a) {
        Color color = new Color(r, g, b, a);
        String hex = Integer.toHexString(color.getRGB() & 0xffffff);
        while (hex.length() < 6) {
            hex = "0" + hex;
        }
        this.colorHex = "#" + hex;
    }

    public void shortHexToHex(String shortHex) {
        char[] charArray = new char[4];
        shortHex.getChars(0, 4, charArray, 0);
        String rhex = Character.toString(charArray[1]);
        String ghex = Character.toString(charArray[2]);
        String bhex = Character.toString(charArray[3]);
        String hex = rhex + rhex + ghex + ghex + bhex + bhex;
        this.colorHex = "#" + hex;
    }

    public void nameToHex(String name) {
        CreateNamesHexListFromFileTableNamesHex createNamesHexListFromFileTableNamesHex = new CreateNamesHexListFromFileTableNamesHex();
        java.util.List<NamesHexTable> namesHexTableList;
        namesHexTableList = createNamesHexListFromFileTableNamesHex.FileTolist();

        //porównuje name z pierwszym polem namesHexTableList, jeśli równość zachodzi, przypisuje zmiennej hex drugie pole
        String hex = "brak szukanego koloru";
        for (NamesHexTable aNamesHexTableList : namesHexTableList) {
            if (aNamesHexTableList.getColorName().equals(name)) {
                hex = aNamesHexTableList.getColorHex();
                this.colorHex = "#" + hex;
            }
        }
        System.out.println("#" + hex);
    }
}
