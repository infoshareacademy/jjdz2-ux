package com.sionach.ux.color;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by allic on 07/10/2016.
 */
public class ExtractColorsFromDataTest {
    @Test
    public void testExtractColors() throws Exception {
        List<String> testStringList = new ArrayList<String>();
        testStringList.add("background-color: #23d4fa;");
        testStringList.add("background-color: #2312aa;");
        testStringList.add("background-color: #b3d1fa;");
        testStringList.add("background-color: rgba(255,255,255,1);");
        testStringList.add("background-color: rgba(255,232,123,2);");
        testStringList.add("background-color: rgba(234,212,134,0);");
        testStringList.add("background-color: rgb(1,255,255);");
        testStringList.add("background-color: rgb(12,232,123);");
        testStringList.add("background-color: rgb(123,212,134);");

        List<String> resultStringList = new ArrayList<String>();
        resultStringList = ExtractColorsFromData.extractHexRgbRgbaColors(testStringList);
        System.out.println(resultStringList);

        assertNotNull(resultStringList);
    }

}