package com.sionach.ux.color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

/**
 * Created by Alice on 17.09.2016.
 */
public class NamesHexTable {
    private String colorName;
    private String colorHex;

    private static final Logger LOGGER = LogManager.getLogger(NamesHexTable.class);

    NamesHexTable() {
        LOGGER.info("Sets default value of color");
        this.setColorName("White");
        this.setColorHex("ffffff");
    }

    NamesHexTable(String colorName, String colorHex) {
        LOGGER.info("Set given value of color");
        this.setColorName(colorName);
        this.setColorHex(colorHex);
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public void splitLineBySpace(String line) {
        LOGGER.info("Splits string line by space");
        String patternString = " ";
        Pattern pattern = Pattern.compile(patternString);
        String[] split = pattern.split(line);
        if (split.length == 2) {
            this.colorName = split[0];
            this.colorHex = split[1];
        }
    }

    public String toString() {

        return "{color:" + this.colorHex + ", colorName:" + this.colorName + "}";
    }
}