package com.sionach.ux.filemanagment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles {

    public ReadFiles(){

    }

    public List<String> readFileToList( String filename) throws IOException {
        List<String> plik1 = new ArrayList<>();
        try(BufferedReader in =new BufferedReader(new FileReader(filename))){
            String c;
            while((c = in.readLine()) !=null){
                plik1.add(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return plik1;
    }
}
