package com.sionach.ux.filemanagment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles {

    private String defaultPatch = "src/main/resources/";

    public String readFileToString(String filename) {

        List<String> plik = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(defaultPatch + filename))) {
            String c;
            while ((c = in.readLine()) != null) {
                plik.add(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = String.join(" ", plik);
        return result;
    }

    public void setDefaultPatch(String defaultPatch) {
        this.defaultPatch = defaultPatch;
    }
}
