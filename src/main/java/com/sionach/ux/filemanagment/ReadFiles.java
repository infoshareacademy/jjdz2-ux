package com.sionach.ux.filemanagment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ReadFiles {

    private String defaultPatch = "src/main/resources/";
    private String filename;

    private static final Logger LOGGER = LogManager.getLogger(ReadFiles.class);

    public List<String> readFileToList(String filename) {

        LOGGER.debug("Starting to read file");
        LOGGER.debug("FilePath: {} FileName {}", defaultPatch, filename);

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
//        LOGGER.debug("Changing file path for file {} to: {}", filename, defaultPatch);
        this.defaultPatch = defaultPatch;
        LOGGER.debug("File path: {}", this.defaultPatch);
    }
}
