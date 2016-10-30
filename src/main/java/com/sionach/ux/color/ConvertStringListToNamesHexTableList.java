package com.sionach.ux.color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Alice on 18.09.2016.
 */
public class ConvertStringListToNamesHexTableList {

    private static final Logger LOGGER = LogManager.getLogger(ConvertStringListToNamesHexTableList.class);

    private List<NamesHexTable> namesHexTableList = new ArrayList<>();

    public List<NamesHexTable> getNamesHexTableList() {
        LOGGER.debug("Get NamesHexTableList form class ConvertStringListToNameHexTable");
        return namesHexTableList;
    }

    public List<NamesHexTable> convertToNamesHexTableList(List<String> stringList) {
        LOGGER.debug("Converts list of strings into list of NamesHexTable objects");
        NamesHexTable namesHexTable = new NamesHexTable();
        for (String aStringList : stringList) {
            namesHexTable.splitLineBySpace(aStringList);
            this.namesHexTableList.add(new NamesHexTable(namesHexTable.getColorName(), namesHexTable.getColorHex()));
            LOGGER.debug("One string line coverted into NamezHexTable object");
        }
        return this.namesHexTableList;
    }

}
