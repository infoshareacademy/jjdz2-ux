package com.sionach.ux.csslists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by drzalek on 02.10.16.
 */
public class PropertiesListsFromCssTest {

    @Test
    public void objectIsNotNull() throws Exception {
        PropertiesListsFromCss listBraces = new PropertiesListsFromCss();
        assertNotNull(listBraces);
    }

    @Test
    public void testPropertiesList() throws Exception {
        List<String> propertiesListTest = new ArrayList<>();
        propertiesListTest.add("width: 20px");
        propertiesListTest.add("overflow: hidden");
        propertiesListTest.add("display: block");
        propertiesListTest.add("color: red");

        PropertiesListsFromCss listBraces = new PropertiesListsFromCss();
        List<String> list = listBraces.propertiesList(propertiesListTest);

        List<String> testList = new ArrayList<>();
        testList.add("width: 20px");
        testList.add("overflow: hidden");
        testList.add("display: block");
        testList.add("color: red");

        assertEquals(list, testList);
    }
}