package com.sionach.ux.csslists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by drzalek on 02.10.16.
 */
public class ValuesListsFromCssTest {

    @Test
    public void testValuesList() throws Exception {
        List<String> valuesListTest = new ArrayList<>();
        valuesListTest.add("20px");
        valuesListTest.add("hidden");
        valuesListTest.add("block");
        valuesListTest.add("red");

        PropertiesListsFromCss listBraces = new PropertiesListsFromCss();
        List<String> list = listBraces.propertiesList(valuesListTest);

        List<String> testList = new ArrayList<>();
        testList.add("20px");
        testList.add("hidden");
        testList.add("block");
        testList.add("red");

        assertEquals(list, testList);
    }
}