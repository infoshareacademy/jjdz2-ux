package com.sionach.ux.color;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alice on 18.09.2016.
 */
public class ConvertColorToHexTest {
    @Test
    public void rgbToHex() throws Exception {
        ConvertColorToHex convertColorToHex = new ConvertColorToHex();
        String colorHex;
        int r = 255;
        int g = 255;
        int b = 255;
        convertColorToHex.rgbToHex(r,g,b);
        colorHex = convertColorToHex.getColorHex();
        System.out.println(colorHex);
        assertNotNull(colorHex);
    }

    @Test
    public void rgbaToHex() throws Exception {
        ConvertColorToHex convertColorToHex = new ConvertColorToHex();
        String colorHex;
        int r = 255;
        int g = 255;
        int b = 255;
        int a = 1;
        convertColorToHex.rgbToHex(r,g,b);
        colorHex = convertColorToHex.getColorHex();
        System.out.println(colorHex);
        assertNotNull(colorHex);
    }

    @Test
    public void shortHexToHex() throws Exception {
        ConvertColorToHex convertColorToHex = new ConvertColorToHex();
        String colorHex;
        String shortHex = "abc";
        convertColorToHex.shortHexToHex(shortHex);
        colorHex = convertColorToHex.getColorHex();
        System.out.println(colorHex);
        assertNotNull(colorHex);
    }

    @Test
    public void nameToHex() throws Exception {
        ConvertColorToHex convertColorToHex = new ConvertColorToHex();
        String colorHex;
        String name = "DarkSlateGrey";
        convertColorToHex.nameToHex(name);
        colorHex = convertColorToHex.getColorHex();
        System.out.println(colorHex);
        assertNotNull(colorHex);
    }

}