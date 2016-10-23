package com.sionach.ux.siteAvailability;

import com.sionach.ux.accessibility.CaseOfHtml5;
import org.junit.Test;

import java.util.List;

/**
 * Created by allic on 14/10/2016.
 */
public class CaseOfHtml5Test {
    @Test
    public void checkIfHtml5() throws Exception {
        List<String> testList;
        String htmlCodeTest = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<header>This is my site</header>"+
                "<body>\n" +
                "\n" +
                "<h2>Spectacular Mountain</h2>\n" +
                "<img src=\"pic_mountain.jpg\" alt=\"Mountain View\" style=\"width:304px;height:228px;\">\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        CaseOfHtml5 caseOfHtml5 = new CaseOfHtml5();
        testList = caseOfHtml5.CheckIfHtml5(htmlCodeTest);
        System.out.println(testList.toString());

    }

}