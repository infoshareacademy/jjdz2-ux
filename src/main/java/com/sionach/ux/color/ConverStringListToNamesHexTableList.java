package com.sionach.ux.color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alice on 18.09.2016.
 */
public class ConverStringListToNamesHexTableList {

    private List<NamesHexTable> namesHexTableList = new ArrayList<>();

    public List<NamesHexTable> getNamesHexTableList() {
        return namesHexTableList;
    }

    public List<NamesHexTable> convertToNamesHexTableList(List<String> stringList) {
        int count = stringList.size();
        System.out.println(count);
        NamesHexTable namesHexTable = new NamesHexTable();
        for (String aStringList : stringList) {
            namesHexTable.splitLineBySpace(aStringList);
            this.namesHexTableList.add(new NamesHexTable(namesHexTable.getColorName(), namesHexTable.getColorHex()));
        }
        return this.namesHexTableList;
    }

}
