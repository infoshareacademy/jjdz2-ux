package com.sionach.ux.color;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alice on 17.09.2016.
 */
public class ReadFileByLines {
    List<String> lines = new ArrayList<>();

    public List<String> getLines() {
        return lines;
    }

    public List<String> readFileToList(String filename) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = in.readLine()) != null) {
                this.lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return this.lines;
    }

}
