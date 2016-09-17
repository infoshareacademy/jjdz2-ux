package com.sionach.ux.filemanagment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReadFilesTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void objectNotNull() throws Exception {
        ReadFiles readFiles = new ReadFiles();
        assertNotNull(readFiles);
    }
    @Test
    public void openFile() throws Exception {
        ReadFiles readFiles = new ReadFiles();
        File tempFile = testFolder.newFile("file.txt");
        readFiles.readFileToString(tempFile.toString());
    }

}