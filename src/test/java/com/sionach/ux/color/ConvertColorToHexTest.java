package com.sionach.ux.color;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by allic on 08/10/2016.
 */
public class ConvertColorToHexTest {
    @Test
    public void setColorHex() throws Exception {
        ConvertColorToHex convertColorToHex = new ConvertColorToHex();
        convertColorToHex.setColorHex("#2f3a45");
        System.out.println(convertColorToHex.getColorHex());
        assertEquals("#2f3a45",convertColorToHex.getColorHex());
    }

    @Test
    public void getColorHex() throws Exception {
        ConvertColorToHex convertColorToHex = new ConvertColorToHex();
        System.out.println(convertColorToHex.getColorHex());
        assertEquals("#000000",convertColorToHex.getColorHex());
    }

    @Test
    public void rgbToHex() throws Exception {
        ConvertColorToHex convertColorToHex = new ConvertColorToHex();
        int r=255;
        int g=255;
        int b=255;
        convertColorToHex.rgbToHex(r,g,b);
        System.out.println(convertColorToHex.getColorHex());
        assertEquals("#ffffff",convertColorToHex.getColorHex());
    }


    @Test
    public void rgbaToHex() throws Exception {
        ConvertColorToHex convertColorToHex = new ConvertColorToHex();
        int r=255;
        int g=255;
        int b=255;
        int a=1;
        convertColorToHex.rgbaToHex(r,g,b,a);
        System.out.println(convertColorToHex.getColorHex());
        assertEquals("#ffffff",convertColorToHex.getColorHex());
    }

    @Test
    public void shortHexToHex() throws Exception {
        ConvertColorToHex convertColorToHex = new ConvertColorToHex();
        String colorString = "abc";
        convertColorToHex.shortHexToHex(colorString);
        System.out.println(convertColorToHex.getColorHex());
        assertEquals("#aabbcc",convertColorToHex.getColorHex());
    }

    @Test
    public void nameToHex() throws Exception {
        ConvertColorToHex convertColorToHex = new ConvertColorToHex();
        String colorString = "YellowGreen";
        convertColorToHex.nameToHex(colorString);
        System.out.println(colorString + " = " + convertColorToHex.getColorHex());
        assertEquals("#9acd32",convertColorToHex.getColorHex());
    }

    @Test
    public void should_differ_color_format() throws Exception {
        ConvertColorToHex convertColorToHex = new ConvertColorToHex();
        String colorString = "YellowGreen";
        convertColorToHex.checkColorFormatAndConvert(colorString);
        System.out.println(convertColorToHex.getColorHex());
    }

}