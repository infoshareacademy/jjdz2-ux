package com.sionach.ux.keyWords;

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
        KeywordsFromBolded keywordsFromBolded = new KeywordsFromBolded();
        String sample = "<b>porszt</b> <strong>jjdz2-materialy</strong> <b><a href=#>JavaSE2_2016.pdf</a></b> <b>1</b>";
        List<String> expected = Arrays.asList("porszt", "jjdz2-materialy", "JavaSE2_2016.pdf", "1");
        assertTrue(keywordsFromBolded.boldedKeywords(sample).equals(expected));
    }

    @Test
    public void shouldFailOnSentenceWithMoreThan8Words(){
        KeywordsFromBolded keywordsFromBolded = new KeywordsFromBolded();
        String sample = "1 2 3 4 5 6 7 8";
        List<String> expected = Arrays.asList("1 2 3 4 5 6 7 8");
        assertFalse(keywordsFromBolded.boldedKeywords(sample).equals(expected));
    }
}