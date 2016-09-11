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

    public List<String> readFileToList( String filename){
        List<String> plik = new ArrayList<>();
        try(BufferedReader in =new BufferedReader(new FileReader(filename))){
            String c;
            while((c = in.readLine()) !=null){
                plik.add(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plik;
    }

    public static void main(String[] args) {


        ReadFiles readFiles = new ReadFiles();
        System.out.println(readFiles.readFileToList("src/main/resources/testowy.html"));
    }
}
