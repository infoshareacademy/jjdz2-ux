package com.sionach.ux.color;

import java.awt.*;

/**
 * Created by Alice on 18.09.2016.
 */
public class ConvertColorToHex {
    private String colorHex;  // format #rrggbb

    ConvertColorToHex(){

        this.colorHex = "#000000";
    }

    public void setColorHex(String colorHex) {

        this.colorHex = colorHex;
    }
    public String getColorHex() {

        return this.colorHex;
    }

    public void checkColorFormatAndConvert(String stringColor) {
        if (stringColor.matches("(?i)#[0-9a-f]{2,6}")) {
            if (stringColor.length() == 7) {
                this.colorHex = stringColor;
            } else {
                shortHexToHex(stringColor);
            }
        } else if (stringColor.matches("(?i)rgba\\([0-9]{1,3},[0-9]{1,3},[0-9]{1,3},[0-1]{0,3}\\)")) {
            stringColor = stringColor.replaceAll("\\("," ");
            stringColor = stringColor.replaceAll("\\)"," ");
            String[] split = stringColor.split(",", 3);
            int r = Integer.parseInt(split[0]);
            int g = Integer.parseInt(split[1]);
            int b = Integer.parseInt(split[2]);
            int a = Integer.parseInt(split[3]);
            rgbaToHex(r,g,b,a);

        }
        else if (stringColor.matches("(?i)rgb\\([0-9]{1,3},[0-9]{1,3},[0-9]{1,3}\\)")) {
            stringColor = stringColor.replaceAll("\\("," ");
            stringColor = stringColor.replaceAll("\\)"," ");
            String[] split = stringColor.split(",", 3);
            int r = Integer.parseInt(split[0]);
            int g = Integer.parseInt(split[1]);
            int b = Integer.parseInt(split[2]);
            rgbToHex(r,g,b);
        }
        else if(stringColor.matches("(?i)[a-z]")){
            nameToHex(stringColor);
        } else{
            throw new IllegalArgumentException();    //Pawel, obsłuz wyjatek w Consoli
        }
    }

    public void rgbToHex(int r, int g, int b){
        Color color = new Color(r,g,b);
        String hex = Integer.toHexString(color.getRGB()&0xffffff);
        while (hex.length() < 6){
            hex = "0" + hex;
        }
        this.colorHex = "#" + hex;
    }

    public void rgbaToHex(int r, int g, int b, int a){
        Color color = new Color(r,g,b,a);
        String hex = Integer.toHexString(color.getRGB()&0xffffff);
        while (hex.length() < 6) {
            hex = "0" + hex;
        }
        this.colorHex = "#" + hex;
    }

    public void shortHexToHex(String shortHex){
        char[] charArray = new char[3];
        shortHex.getChars(0,3,charArray,0);
        String rhex = Character.toString(charArray[0]);
        String ghex = Character.toString(charArray[1]);
        String bhex = Character.toString(charArray[2]);
        String hex = rhex + rhex + ghex + ghex + bhex + bhex;
        this.colorHex = "#" + hex;
    }

    public void nameToHex(String name){
        CreateNamesHexListFromFileTableNamesHex createNamesHexListFromFileTableNamesHex = new CreateNamesHexListFromFileTableNamesHex();
        java.util.List<NamesHexTable> namesHexTableList;
        namesHexTableList =  createNamesHexListFromFileTableNamesHex.FileTolist();

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
