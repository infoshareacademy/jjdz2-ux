package com.sionach.ux.color;

import com.sionach.ux.filemanagment.ReadFiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CreateNamesHexListFromFileTableNamesHex {

    private static final Logger LOGGER = LogManager.getLogger(CreateNamesHexListFromFileTableNamesHex.class);

    public List<NamesHexTable> FileTolist() {
        LOGGER.debug("Attempt to read the file");
        ReadFiles readFile = new ReadFiles();
        List<String> stringList;
        stringList = readFile.readFileToList("src/main/resources/tableNamesHex.txt");

        LOGGER.debug("Convert string list into namesHexTable list");
        List<NamesHexTable> namesHexTableLists;
        ConvertStringListToNamesHexTableList testVariable = new ConvertStringListToNamesHexTableList();
        namesHexTableLists = testVariable.convertToNamesHexTableList(stringList);

        return namesHexTableLists;
    }
}
