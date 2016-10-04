package com.sionach.ux.filemanagment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles {

    private String defaultPatch = "src/main/resources/";

    public List<String> readFileToList(String filename) {

        List<String> fileList = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(defaultPatch + filename))) {
            String c;
            while ((c = in.readLine()) != null) {
                fileList.add(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileList;
    }

    public String readFileToString(String filename){

        List<String> fileList = new ArrayList<>();
        fileList = readFileToList(filename);
        String fileString = String.join(" ", fileList);

        return fileString;
    }

    public void setDefaultPatch(String defaultPatch) {
        this.defaultPatch = defaultPatch;
    }
}
