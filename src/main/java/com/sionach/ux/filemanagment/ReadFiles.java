package com.sionach.ux.filemanagment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles {

    private String defaultPatch = "src/main/resources/";
    private String FILENAME;

    private static final Logger LOGGER = LogManager.getLogger(ReadFiles.class);

    public ReadFiles(String filename) {

        this.FILENAME = filename;
    }

    public List<String> readFileToList() {

        LOGGER.debug("FilePath: {} FileName {}", defaultPatch, FILENAME);

        List<String> fileList = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(defaultPatch + FILENAME))) {
            String c;
            while ((c = in.readLine()) != null) {
                fileList.add(c);
            }
            LOGGER.debug("Reading file to list");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LOGGER.debug("Returning file as list");
        return fileList;
    }

    public String readFileToString() {

        List<String> fileList;
        fileList = readFileToList();
        LOGGER.debug("Convering List to String");
        String fileString = String.join(" ", fileList);
        LOGGER.debug("Returning file as String");
        return fileString;
    }

    public void setDefaultPatch(String defaultPatch) {
        LOGGER.debug("Changing file path to: {}", defaultPatch);
        this.defaultPatch = defaultPatch;
        LOGGER.debug("File path: {}", this.defaultPatch);
    }
}
