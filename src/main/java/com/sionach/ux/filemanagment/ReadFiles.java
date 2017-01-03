package com.sionach.ux.filemanagment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class ReadFiles {

    private static final Logger LOGGER = LogManager.getLogger(ReadFiles.class);
    private String defaultPatch = "target/classes/";

    public List<String> readFileToList(String filename) {

        LOGGER.debug("Starting to read file: {}", filename);

        List<String> fileList = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(defaultPatch + filename))) {
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

        LOGGER.debug("Return file as list");
        return fileList;
    }

    public String readFileToString(String filename) {

        List<String> fileList;
        fileList = readFileToList(filename);
        LOGGER.debug("Convering List to String");
        String fileString = String.join(" ", fileList);
        LOGGER.debug("Return file as String");
        return fileString;
    }

    public void setDefaultPatch(String defaultPatch) {
        this.defaultPatch = defaultPatch;
    }
}
