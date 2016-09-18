package com.sionach.ux.filemanagment;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReadFilesTest {

    @Test
    public void objectNotNull() throws Exception {
        ReadFiles readFiles = new ReadFiles();
        assertNotNull(readFiles);
    }

    @Test
    public void readingFiles() throws Exception {
        ReadFiles readFiles = new ReadFiles();
        readFiles.setDefaultPatch("src/main/Test/resources/");
        assertTrue("Return String as expected", readFiles.readFileToString("testowy.html").equals("testowy     testowy             testowy"));
    }

    @Test
    public void shouldReturnEmptyWhenFileNotFound() throws Exception{
        ReadFiles readFiles = new ReadFiles();
    }
}