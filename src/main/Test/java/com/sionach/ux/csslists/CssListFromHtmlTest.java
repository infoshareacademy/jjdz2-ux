package com.sionach.ux.csslists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by webownia on 29.09.16.
 */
public class CssListFromHtmlTest {
    @Test
    public void codeInlineList() throws Exception {
        String htmlCodeTest = "<p style=\"width:20px; height: 30px;\"></p><p style=\"background-color: black;\"></p>";
        CssListFromHtml cssList = new CssListFromHtml();
        List<String> inLineList = cssList.codeInlineList(htmlCodeTest);

        List<String> testList = new ArrayList<>();
        testList.add("width:20px; height: 30px;");
        testList.add("background-color: black;");
    }

    @Test
    public void codeHeadList() throws Exception {

    }

}