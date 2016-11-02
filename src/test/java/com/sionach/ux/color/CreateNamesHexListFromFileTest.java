package com.sionach.ux.color;

import org.junit.Test;

/**
 * Created by allic on 08/10/2016.
 */
public class CreateNamesHexListFromFileTest {
    @Test
    public void fileTolist() throws Exception {
        CreateNamesHexListFromFile createNamesHexListFromFile = new CreateNamesHexListFromFile();
        createNamesHexListFromFile.fileToStringList();
    }

}