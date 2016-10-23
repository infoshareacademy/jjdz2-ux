package com.sionach.ux.color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateNamesHexListFromFileTableNamesHex {


    public List<NamesHexTable> FileTolist(){
        //czyta plik tableNamesHex do String Listy
        ReadFileByLines readFileByLines = new ReadFileByLines();
        List<String> stringList = new ArrayList<>();
        try{
            stringList = readFileByLines.readFileToList("src/main/resources/tableNamesHex.txt");
        }catch(IOException e){System.out.println("Odczyt pliku nie dziala");}

        //konwertuje String listę w listę obiektów klasy NamesHexTable
        List<NamesHexTable> namesHexTableLists;
        ConverStringListToNamesHexTableList testVariable = new ConverStringListToNamesHexTableList();
        namesHexTableLists = testVariable.convertToNamesHexTableList(stringList);

        return namesHexTableLists;
    }
}
