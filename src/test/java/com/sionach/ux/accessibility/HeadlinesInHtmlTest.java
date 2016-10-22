package com.sionach.ux.accessibility;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by webownia on 22.10.16.
 */
public class HeadlinesInHtmlTest {

    private static String htmlCode;
    private static HeadlinesInHtml headlines;
    @BeforeClass
    public static void testLinks(){
        htmlCode = "<html><head></head><body><h1>Nagłówke rzędu pierwszego</h1><p>Jakiś tekst</p><h2>Nagłówke rzędu drugiego</h2><p>Kolejny tekst</p></body></html>";
        headlines = new HeadlinesInHtml();
    }

    @Test
    public void checkNoOccurrancesH1() throws Exception {
        assertEquals(headlines.checkNoOccurrancesH1(htmlCode),"Nagłówek pierwszego rzędu prawidłowo występuje tylko raz na stronie");
    }

    @Test
    public void checkHeadlinesInHtml() throws Exception {
        assertEquals(headlines.checkHeadlinesInHtml(htmlCode),"Twoja strona posiada nagłówki");
    }

}