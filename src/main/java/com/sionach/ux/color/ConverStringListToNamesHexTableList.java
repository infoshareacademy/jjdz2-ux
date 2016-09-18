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
        for (int i=0; i < count; i++){
            System.out.println(stringList.get(i));
            namesHexTable.splitLineBySpace(stringList.get(i));
            this.namesHexTableList.add(new NamesHexTable(namesHexTable.getColorName(),namesHexTable.getColorHex()));
        }
        return this.namesHexTableList;
    }

}
