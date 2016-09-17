package com.sionach.ux.color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alice on 17.09.2016.
 */
public class DemoClass {

    public static void main(String[] args) throws IOException {
        List<namesHexTable> namesHexTableList = new ArrayList<>(); //Lista z tabelą kolorow nazwa-hex

        readFileByLines readFileByLines = new readFileByLines(); //instancja klasy readFileByLines
        List<String> stringList = new ArrayList<>(); //lista String potrzebna do wywołania metody klasy readFileBy Lines
        stringList = readFileByLines.readFileToList("tableNamesHex.txt");
        System.out.println(stringList);
        int count = stringList.size();
        System.out.println(count);
        //mamy zczytany plik, należy go sparsowac
        // po " " i wczytać d namesHexTableList. Każdy element stringList parsujemy i zapisujemy do elementu namesHexTableList
        namesHexTable namesHexTable = new namesHexTable();
        for (int i=0; i < count; i++){
            System.out.println(stringList.get(i));
            namesHexTable.method1(stringList.get(i));
            namesHexTableList.add(new namesHexTable(namesHexTable.getColorName(),namesHexTable.getColorHex()));
        }
        System.out.println(namesHexTableList);


        //namesHexTable namesHexTable = new namesHexTable();
        //String string1;
        //String string2;
        //for (String line: stringList){
        //    namesHexTable.method1(line); // to nie dziala
        //    string1 = namesHexTable.getColorName();
        //    string2 = namesHexTable.getColorHex();
        //    namesHexTableList.add(new namesHexTable(string1,string2));
        //}
        //System.out.println(namesHexTableList);

       // namesHexTable newTable = new namesHexTable("Black","000000");
       // String string1=newTable.getColorName();
       // String string2=newTable.getColorHex();
       // System.out.println(string1 + " and " + string2 + " are the same colors");
       // newTable.setColorName("White");
       // newTable.setColorHex("ffffff");
       // System.out.println(newTable.getColorName() + " and " + newTable.getColorHex() + " are the same colors too");
       // String string3 = "violet 902090";
       // System.out.println(string3);
       // newTable.method1(string3);
       // System.out.println(newTable.getColorName() + " and " + newTable.getColorHex() + " are the same colors too");
    }

}
