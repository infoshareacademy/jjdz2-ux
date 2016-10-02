package com.sionach.ux.color;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Alice on 18.09.2016.
 */
public class NamesHexTableTest{
    @Test
    public void should_create_unequal() {
        NamesHexTable namesHexTable1 = new NamesHexTable();
        NamesHexTable namesHexTable2 = new NamesHexTable("Black", "White");
        Assert.assertNotEquals(namesHexTable1, namesHexTable2);
    }

    @Test
    public void should_convert_list() { //nie wykorzystuje klasy ConvertStringToNamesHexTableList bo dzialanie tej
        //klasy sprawdza test odpowiedni tej klasie
        List<NamesHexTable> namesHexTableList = new ArrayList<>(); //Lista z tabelą kolorow nazwa-hex
        ReadFileByLines readFileByLines = new ReadFileByLines(); //instancja klasy ReadFileByLines
        List<String> stringList = new ArrayList<>();
        try{
            stringList = readFileByLines.readFileToList("src/main/resources/tableNamesHex.txt");
            System.out.println(stringList);
            int count = stringList.size();
            System.out.println(count);
            NamesHexTable namesHexTable = new NamesHexTable();

            for (int i=0; i < count; i++){
                System.out.println(stringList.get(i));
                namesHexTable.splitLineBySpace(stringList.get(i));
                namesHexTableList.add(new NamesHexTable(namesHexTable.getColorName(),namesHexTable.getColorHex()));
            }
            System.out.println(namesHexTableList);
        }catch(IOException e){System.out.println("Odczyt pliku nie dziala");}
        assertNotNull(namesHexTableList);
        assertNotNull(stringList);

    }
}
