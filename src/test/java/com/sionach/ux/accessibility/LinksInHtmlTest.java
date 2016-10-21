package com.sionach.ux.accessibility;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by drzal on 21.10.2016.
 */
public class LinksInHtmlTest {
    public static String info;
    public static String htmlCode;
    public static LinksInHtml links;
    @BeforeClass
    public static void testLinks(){
        htmlCode = "<html><head></head><body><a href=\"#kontakt\">kontakt</a> Jakiś tekst <a href=\"http://google.pl\">google</a>Kolejny tekst <a href=\"index.html\">strona główna</a></body></html>";
        links = new LinksInHtml();
    }

    @Test
    public void should_be_string_with_2_links() throws Exception {
        assertEquals(links.checkNumberOfLinks(htmlCode),"Znaleziono 2 linków na Twojej stronie. Liczba linków jest mniejsza niż 100, więc jest prawidłowa");
    }

}