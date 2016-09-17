package com.sionach.ux.filemanagment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;

import static org.junit.Assert.*;

public class ReadFilesTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void objectNotNull() throws Exception {
        ReadFiles readFiles = new ReadFiles();
        assertNotNull(readFiles);
    }
    //todo test na pliku z resources
    @Test
    public void openFile() throws Exception {
        ReadFiles readFiles = new ReadFiles();
        File tempFile = testFolder.newFile("file.txt");
        readFiles.readFileToString(tempFile.toString());
    }
}