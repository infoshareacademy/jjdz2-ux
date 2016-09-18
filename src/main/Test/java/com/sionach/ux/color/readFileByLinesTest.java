package com.sionach.ux.color;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Alice on 18.09.2016.
 */
public class readFileByLinesTest {
@Test
    public void should_read_file() {
    readFileByLines readFileByLines = new readFileByLines(); //instancja klasy readFileByLines
    List<String> stringList = new ArrayList<>(); //lista String potrzebna do wywołania metody klasy readFileBy Lines
    try{
        stringList = readFileByLines.readFileToList("src/main/resources/tableNamesHex.txt");
        System.out.println(stringList);
        int count = stringList.size();
        System.out.println(count);
    }catch(IOException e){System.out.println("Odczyt pliku nie dziala");}
    assertNotNull(stringList);
}
}