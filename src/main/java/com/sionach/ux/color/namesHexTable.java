package com.sionach.ux.color;

import java.util.regex.Pattern;

/**
 * Created by Alice on 14.09.2016.
 */
public class namesHexTable {  //klasa zawiera nazwy kolorow i przypisane im HEX
    private String colorName;
    private String colorHex;

    namesHexTable(String colorName, String colorHex){
        System.out.println("kontruktor z dwoma parametrami klasy namesHexTable");
        this.colorName = colorName;
        this.colorHex = colorHex;
    }

    public void setColorName(String colorName){
        this.colorName = colorName;
    }
    public void setColorHex(String colorHex){
        this.colorHex = colorHex;
    }

    public String getColorName() {
        return colorName;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void method1(String line){ //metoda przyjmujaca linie zlozona z dwoch wyrazow
        // i zapisujaca pierwszy wyraz do colorName, zas drugi do color Hex

        String patternString = " " ;
        Pattern pattern = Pattern.compile(patternString);

        String[] split = pattern.split(line);
        if (split.length == 2) {
            this.colorName = split[0];
            this.colorHex = split[1];
        }
        else {
            System.out.println("Wrong input line");
        }

    }
}
// complete

