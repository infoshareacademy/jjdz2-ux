package com.sionach.ux.color;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Alice on 18.09.2016.
 */
public class ConverStringListToNamesHexTableListTest {
    @Test
    public void should_convert_stringList_to_namesHexTableList(){
        List<String> stringList = new ArrayList<>();
        stringList.add("White ffffff");
        stringList.add("Yellow ffff00");
        stringList.add("Sienna a0522d");

        List<NamesHexTable> namesHexTableList = new ArrayList<>();
        ConvertStringListToNamesHexTableList testVariable = new ConvertStringListToNamesHexTableList();

        namesHexTableList = testVariable.convertToNamesHexTableList(stringList);
        System.out.println(namesHexTableList);
        assertNotNull(namesHexTableList);
    }

}