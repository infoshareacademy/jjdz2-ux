package com.sionach.ux.keyWords;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by webownia on 29.09.16.
 */
public class KeywordsFromAttributesTest {

    @Test
    public void attributesKeywords() throws Exception{
        String htmlCodeTest = "<img src=\"\" alt=\"Pierwsze slowo kluczowe\" title=\"drugie slowo kluczowe\"><img src=\"\" alt=\"trzecie\" title=\"czwarte\">";
        KeywordsFromAttributes keywords = new KeywordsFromAttributes();
        List<String> keywordsList = keywords.attributesKeywords(htmlCodeTest);

        List<String> testList = new ArrayList<>();
        testList.add("Pierwsze slowo kluczowe");
        testList.add("drugie slowo kluczowe");
        testList.add("trzecie");
        testList.add("czwarte");

        assertEquals(keywordsList, testList);
    }

}