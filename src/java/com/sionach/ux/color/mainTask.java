package com.sionach.ux.color;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alice on 14.09.2016.
 */
public class mainTask {

    public List<String> readFileToList(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = in.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        List<namesHexTable> colors = new ArrayList<namesHexTable>();
        String line = new String;

        splitLineTab.splitting(line);
        colors.add(new namesHexTable(twoElements[1],twoElements[2]));
    }
}
