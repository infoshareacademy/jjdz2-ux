package com.sionach.ux.color;

import com.sionach.ux.filemanagment.ReadFiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class CreateNamesHexListFromFileTableNamesHex {

    private static final Logger LOGGER = LogManager.getLogger(CreateNamesHexListFromFileTableNamesHex.class);

    private List<NamesHexTable> namesHexTableList;

    public List<NamesHexTable> fileToStringList() {
        LOGGER.debug("Attempt to read the file");
        ReadFiles readFile = new ReadFiles();
        List<String> stringList;
        stringList = readFile.readFileToList("tableNamesHex.txt");

        LOGGER.debug("Convert string list into namesHexTable list");
        namesHexTableList = StringListToNamesHexTableList(stringList);

        return namesHexTableList;
    }

    private List<NamesHexTable> StringListToNamesHexTableList(List<String> stringList) {
        LOGGER.debug("Converts list of strings into list of NamesHexTable objects");
        NamesHexTable namesHexTable = new NamesHexTable();
        for (String aStringList : stringList) {
            namesHexTable.splitLineBySpace(aStringList);
            namesHexTableList.add(new NamesHexTable(namesHexTable.getColorName(), namesHexTable.getColorHex()));
            LOGGER.debug("One string line converted into NamesHexTable object");
        }
        return namesHexTableList;
    }
}
