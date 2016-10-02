package com.sionach.ux.keyWords;

import com.sionach.ux.filemanagment.ReadFiles;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class KeywordsFromBoldedTest {

    @Test
    public void notNullObject(){
        KeywordsFromBolded keywordsFromBolded = new KeywordsFromBolded();
        assertNotNull(keywordsFromBolded);
    }

    @Test
    public void shouldReturnBoldedAndStrong(){
        ReadFiles readFiles = new ReadFiles();
        KeywordsFromBolded keywordsFromBolded = new KeywordsFromBolded();
        List<String> expected = Arrays.asList("porszt", "JavaSE2_2016.pdf", "1");
        assertTrue("test", keywordsFromBolded.boldedKeywords(readFiles.readFileToString("testowy2.html")).equals(expected));
    }
}