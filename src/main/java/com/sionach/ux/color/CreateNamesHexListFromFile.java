package com.sionach.ux.color;

import com.sionach.ux.filemanagment.ReadFiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CreateNamesHexListFromFile {

    private static final Logger LOGGER = LogManager.getLogger(CreateNamesHexListFromFile.class);



    public List<NamesHexTable> fileToStringList() {
        LOGGER.debug("Attempt to read the file");
        List<NamesHexTable> namesHexTableList;
        ReadFiles readFile = new ReadFiles();
        List<String> stringList;
        stringList = readFile.readFileToList("tableNamesHex.txt");

        LOGGER.debug("Convert string list into namesHexTable list");
        namesHexTableList = StringListToNamesHexTableList(stringList);

        return namesHexTableList;
    }

    private List<NamesHexTable> StringListToNamesHexTableList(List<String> stringList) {
        LOGGER.debug("Converts list of strings into list of NamesHexTable objects");
        List<NamesHexTable> namesHexTableLists = new ArrayList<>();
        NamesHexTable namesHexTable = new NamesHexTable();
        for (String aStringList : stringList) {
            namesHexTable.splitLineBySpace(aStringList);
            namesHexTableLists.add(new NamesHexTable(namesHexTable.getColorName(), namesHexTable.getColorHex()));
            LOGGER.debug("One string line converted into NamesHexTable object");
        }
        return namesHexTableLists;
    }
}
