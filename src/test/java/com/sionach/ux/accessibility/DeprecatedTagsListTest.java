package com.sionach.ux.accessibility;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by webownia on 16.10.16.
 */
public class DeprecatedTagsListTest {

    @Test
    public void createDeprecatedTagsListTest() throws FileNotFoundException {
        DeprecatedTagsList tagsList = new DeprecatedTagsList();
        List<String> list = tagsList.createDeprecatedTagsList("src/test/resources/deprecatedTags.txt");

        List<String> testList = new ArrayList<>();
        testList.add("acronym");
        testList.add("applet");
        testList.add("basefont");
        testList.add("big");
        testList.add("center");
        testList.add("font");
        testList.add("frame");
        testList.add("frameset");
        testList.add("isindex");
        testList.add("noframes");
        testList.add("s");
        testList.add("strike");
        testList.add("tt");
        testList.add("u");



        assertEquals(list, testList);

    }

}