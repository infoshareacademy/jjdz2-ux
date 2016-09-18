package com.sionach.ux.filemanagment;

import jdk.nashorn.internal.runtime.ECMAException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;

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
        assertTrue("test", readFiles.readFileToString("testowy.html").equals("testowy     testowy             testowy"));
    }
}