package com.sionach.ux.filemanagment;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ReadFilesTest {

    @Test
    public void objectNotNull() throws Exception {
        ReadFiles readFiles = new ReadFiles();
        assertNotNull(readFiles);
    }

    @Test
    public void shouldReturnString() throws Exception {
        ReadFiles readFiles = new ReadFiles();
        readFiles.setDefaultPatch("src/test/resources/");
        assertTrue("Return String as expected", readFiles.readFileToString("testowy.html").equals("testowy     testowy             testowy"));
    }

    @Test
    public void shouldReturnList() throws Exception {
        ReadFiles readFiles = new ReadFiles();
        readFiles.setDefaultPatch("src/test/resources/");
        List<String> expectedList = new ArrayList<>();
        expectedList.addAll(Arrays.asList("testowy", "    testowy", "            testowy"));
        assertTrue("Return List as expected", expectedList.equals(readFiles.readFileToList("testowy.html")));
    }
}