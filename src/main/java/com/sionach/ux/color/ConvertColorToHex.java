package com.sionach.ux.color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import java.awt.*;

@Stateless
public class ConvertColorToHex {
    private String colorHex;  // format #rrggbb

    private static final Logger LOGGER = LogManager.getLogger(ConvertColorToHex.class);

    public ConvertColorToHex() {
        LOGGER.debug("Set the default value for color");
        this.colorHex = "#000000";
    }

    public String checkColorFormatAndConvert(String stringColor) {
        LOGGER.debug("Checking color format");
        if (stringColor.matches("(?i)#[0-9a-f]{2,6}")) {
            LOGGER.info("Color is some HEX");
            if (stringColor.length() == 7) {
                LOGGER.info("Color is HEX");
                this.colorHex = stringColor;
            } else {
                LOGGER.info("Color is short HEX");
                shortHexToHex(stringColor);
            }
        } else if (stringColor.matches("(?i)rgba\\([0-9]{1,3},[0-9]{1,3},[0-9]{1,3},[0-1]{0,3}\\)")) {
            LOGGER.info("Color is rgba");
            stringColor = stringColor.replaceAll("\\(", " ");
            stringColor = stringColor.replaceAll("\\)", " ");
            stringColor = stringColor.replaceAll("rgba", " ");
            stringColor = stringColor.trim();
            String[] split = stringColor.split(",", 4);
            int r = Integer.valueOf(split[0]);
            int g = Integer.valueOf(split[1]);
            int b = Integer.valueOf(split[2]);
            int a = Integer.valueOf(split[3]);
            rgbaToHex(r, g, b, a);

        } else if (stringColor.matches("(?i)rgb\\([0-9]{1,3},[0-9]{1,3},[0-9]{1,3}\\)")) {
            LOGGER.info("Color is rgb");
            stringColor = stringColor.replaceAll("\\(", " ");
            stringColor = stringColor.replaceAll("\\)", " ");
            stringColor = stringColor.replaceAll("rgb", " ");
            stringColor = stringColor.trim();
            String[] split = stringColor.split(",", 3);
            int r = Integer.valueOf(split[0]);
            int g = Integer.valueOf(split[1]);
            int b = Integer.valueOf(split[2]);
            rgbToHex(r, g, b);

        } else {
            LOGGER.info("It might be color name");
            nameToHex(stringColor);
        }
        return stringColor;
    }

    public void rgbToHex(int r, int g, int b) {
        LOGGER.debug("Starts rgb to hex conversion");
        Color color = new Color(r, g, b);
        String hex = Integer.toHexString(color.getRGB() & 0xffffff);
        while (hex.length() < 6) {
            hex = "0" + hex;
        }
        this.colorHex = "#" + hex;
    }

    public void rgbaToHex(int r, int g, int b, int a) {
        LOGGER.debug("Starts rgba to hex conversion");
        Color color = new Color(r, g, b, a);
        String hex = Integer.toHexString(color.getRGB() & 0xffffff);
        while (hex.length() < 6) {
            hex = "0" + hex;
        }
        this.colorHex = "#" + hex;
    }

    public void shortHexToHex(String shortHex) {
        LOGGER.debug("Starts short hex to hex conversion");
        if (shortHex.length() == 4) {
            char[] charArray = new char[4];
            shortHex.getChars(0, 4, charArray, 0);
            String rhex = Character.toString(charArray[1]);
            String ghex = Character.toString(charArray[2]);
            String bhex = Character.toString(charArray[3]);
            String hex = rhex + rhex + ghex + ghex + bhex + bhex;
            this.colorHex = "#" + hex;
        }
    }

    public void nameToHex(String name) {
        LOGGER.debug("Starts color name to hex conversion");
        CreateNamesHexListFromFileTableNamesHex createNamesHexListFromFileTableNamesHex = new CreateNamesHexListFromFileTableNamesHex();
        java.util.List<NamesHexTable> namesHexTableList;
        namesHexTableList = createNamesHexListFromFileTableNamesHex.FileTolist();

        //porównuje name z pierwszym polem namesHexTableList, jeśli równość zachodzi, przypisuje zmiennej hex drugie pole
        String hex = "brak szukanego koloru";
        for (NamesHexTable aNamesHexTableList : namesHexTableList) {
            if (aNamesHexTableList.getColorName().equals(name)) {
                hex = aNamesHexTableList.getColorHex();
                this.colorHex = "#" + hex;
                LOGGER.info("It is a color name!");
            }
        }
        System.out.println("#" + hex);
    }

    public String getColorHex() {
        LOGGER.debug("Gets color hex");
        return this.colorHex;
    }

    public void setColorHex(String colorHex) {
        LOGGER.debug("Sets color hex");
        this.colorHex = colorHex;
    }
}
