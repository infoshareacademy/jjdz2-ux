package com.sionach.ux.color;

/**
 * Created by Alice on 14.09.2016.
 */
public class namesHexTable {  //klasa zawiera nazwy kolorow i przypisane im HEX
    private String colorName;
    private String colorHex;

    public namesHexTable(String colorName, String colorHex){
        this.colorName = colorName;
        this.colorHex = colorHex;
    }

    public String getColorName() {return colorName};

    public String getColorHex() {return colorHex};
}
// complete