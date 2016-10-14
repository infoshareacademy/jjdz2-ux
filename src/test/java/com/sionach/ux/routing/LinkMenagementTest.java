package com.sionach.ux.routing;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkMenagementTest {

    public static String testCode;
    public static String baseUrl;
    public static LinkMenagement linkMenagement;

    @BeforeClass
    public static void makeTestLinks(){
        baseUrl = "testowadomena.pl";
        testCode = "SomeRandomCode<a href=\"http://www.testowa.com domena.com\">A</a>SomeRandomCode" +
                "<a href=\"testowadomena.pl\">B</a>SomeRandomCode, SomeRandomCode<>SomeRandomCode" +
                "<a href=\"test3.com testowadomena.pl\">C</a>/test/test.SomeRandomCode";
        linkMenagement = new LinkMenagement(testCode, baseUrl);
    }

    @Test
    public void shouldReturn3Links(){
        assertTrue(linkMenagement.getLinks().size()==3);
    }

    @Test
    public void shouldReturn2LinksWithBaseURL(){
        linkMenagement.makeInnerLinks();
        assertTrue(linkMenagement.getInnerLinks().size()==2);
    }

    @Test
    public void shouldReturn1LinkWithOutBaseURL(){
        linkMenagement.makeOuterLinks();
        assertTrue(linkMenagement.getOuterLinks().size()==1);
    }
}