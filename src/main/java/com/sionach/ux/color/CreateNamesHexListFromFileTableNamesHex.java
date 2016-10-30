package com.sionach.ux.color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateNamesHexListFromFileTableNamesHex {

    private static final Logger LOGGER = LogManager.getLogger(CreateNamesHexListFromFileTableNamesHex.class);

    public List<NamesHexTable> FileTolist() {
        LOGGER.debug("Attempt to read the file");
        ReadFileByLines readFileByLines = new ReadFileByLines();
        List<String> stringList = new ArrayList<>();
        try {
            stringList = readFileByLines.readFileToList("src/main/resources/tableNamesHex.txt");
        } catch (IOException e) {
            System.out.println("Odczyt pliku nie dziala");
        }

        LOGGER.debug("Convert string list into namesHexTable list");
        List<NamesHexTable> namesHexTableLists;
        ConvertStringListToNamesHexTableList testVariable = new ConvertStringListToNamesHexTableList();
        namesHexTableLists = testVariable.convertToNamesHexTableList(stringList);

        return namesHexTableLists;
    }
}
