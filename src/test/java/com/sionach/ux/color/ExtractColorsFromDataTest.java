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

        List<String> resultStringList = new ArrayList<String>();
        resultStringList = ExtractColorsFromData.extractColors(testStringList);
        System.out.println(resultStringList);

        assertNotNull(resultStringList);
    }

}