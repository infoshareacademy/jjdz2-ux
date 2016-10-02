package com.sionach.ux.csslists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by webownia on 18.09.16.
 */
public class ListsFromCssTest {
    @Test
    public void objectIsNotNull() throws Exception {
        ListsFromCss listBraces = new ListsFromCss();
        assertNotNull(listBraces);
    }

    @Test
    public void bracesListTest() {
        ListsFromCss listBraces = new ListsFromCss();
        List<String> list = listBraces.bracesList("article{width:20px;} td{background-color: black;}");

        List<String> testList = new ArrayList<>();
        testList.add("width:20px;");
        testList.add("background-color: black;");

        assertEquals(list, testList);

    }


}