package com.sionach.ux.color;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

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


    public void rgbToHex(int r, int g, int b){
        Color color = new Color(r,g,b);
        String hex = Integer.toHexString(color.getRGB()&0xffffff);
        do {
            hex = "0" + hex;
        }while (hex.length() < 6);
        this.colorHex = "#" + hex;
    }

    public void rgbToHex(int rgb){
        Color color = new Color(rgb);
        String hex = Integer.toHexString(color.getRGB()&0xffffff);
        do {
            hex = "0" + hex;
        }while (hex.length() < 6);
        this.colorHex = "#" + hex;
    }


    public void rgbaToHex(int r, int g, int b, int a){
        Color color = new Color(r,g,b,a);
        String hex = Integer.toHexString(color.getRGB()&0xffffff);
        do {
            hex = "0" + hex;
        }while (hex.length() < 6);
        this.colorHex = "#" + hex;
    }

    public void shortHexToHex(String shortHex){
        char[] charArray = new char[3];
        shortHex.getChars(0,2,charArray,0);
        String rhex = Character.toString(charArray[0]);
        String ghex = Character.toString(charArray[1]);
        String bhex = Character.toString(charArray[2]);
        String hex = rhex + rhex + ghex + ghex + bhex + bhex;
        this.colorHex = "#" + hex;
    }

    public void nameToHex(String name){
        //czyta plik tableNamesHex do String Listy
        ReadFileByLines readFileByLines = new ReadFileByLines();
        java.util.List<String> stringList = new ArrayList<>();
        try{
            stringList = readFileByLines.readFileToList("src/main/resources/tableNamesHex.txt");
            System.out.println(stringList);
            int count = stringList.size();
            System.out.println(count);
        }catch(IOException e){System.out.println("Odczyt pliku nie dziala");}

        //konwertuje String listę w listę obiektów klasy NamesHexTable
        List<NamesHexTable> namesHexTableList = new ArrayList<>();
        ConverStringListToNamesHexTableList testVariable = new ConverStringListToNamesHexTableList();
        namesHexTableList = testVariable.convertToNamesHexTableList(stringList);

        //porównuje name z pierwszym polem namesHexTableList, jeśli równość zachodzi, przypisuje zmiennej hex drugie pole
        String hex = "brak szukanego koloru";
        int count = namesHexTableList.size();
        for (int i = 0; i < count; i++){
            if(namesHexTableList.get(i).getColorName()==name) {
                hex = namesHexTableList.get(i).getColorHex();
                this.colorHex = "#" + hex;
            }
        }
        System.out.println("#" + hex);
    }
}
