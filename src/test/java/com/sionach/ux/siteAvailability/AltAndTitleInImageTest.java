package com.sionach.ux.siteAvailability;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by allic on 14/10/2016.
 */
public class AltAndTitleInImageTest {
    @Test
    public void imageAltTitle() throws Exception {
        List<String> testList;
        String htmlCodeTest = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>Spectacular Mountain</h2>\n" +
                "<img src=\"pic_mountain.jpg\" alt=\"Mountain View\" style=\"width:304px;height:228px;\">\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        AltAndTitleInImage altAndTitleInImage = new AltAndTitleInImage();
        testList = altAndTitleInImage.ImageAltTitle(htmlCodeTest);
        System.out.println(testList.toString());

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Mountain View");
        System.out.print(expectedList.toString());

        assertEquals(expectedList,testList);
    }

}