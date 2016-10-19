package com.sionach.ux.accessibility;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by webownia on 17.10.16.
 */
public class SettingsInHeadElementTest {
    @Test
    public void checkHeadSettings() throws Exception {
        String htmlCodeTest = "<html lang=\"pl-PL\"><head><title>To jest jakiś tytuł strony</title><link rel=\"canonical\" href=\"http://domena.pl\"></head>";
        SettingsInHeadElement settingList = new SettingsInHeadElement();
        List<String> infoList = settingList.checkHeadSettings(htmlCodeTest);

        List<String> testList = new ArrayList<>();
        testList.add("META description nie zostało ustawione, powinno mieć długość od 150 do 160 znaków");
        testList.add("Tag TITLE ma 26 znaków i jest prawidłowo ustawiony. Upewnij się, że liczba znaków w tagu wynosi około 55 i ma nie więcej niż 60");
        testList.add("LINK rel=canonical jest ustawiony poprwanie");
        testList.add("Zaleca się ustawienie kodowania dokumentu HTML na utf-8");
        testList.add("Twój dokument HTML ma prawidłowy format atrybutu lang");

        assertEquals(infoList, testList);
    }

}