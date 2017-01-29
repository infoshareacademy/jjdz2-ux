package com.sionach.ux.accessibility;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by webownia on 16.10.16.
 */
public class DeprecatedTagsInHtmlTest {
    @Test
    public void findDeprecatedTags() throws Exception {
        DeprecatedTagsInHtml deprecatedTags = new DeprecatedTagsInHtml();
        //List<String> list = deprecatedTags.findDeprecatedTags("<!DOCTYPE HTML> <center><p>Thie text i <strike>strike</strike>. The strike tag is deprecated. The paragraph is centered by deprecated tag center.</p></center> ");

        List<String> test = new ArrayList<>();
        test.add("Tag: <center> nie jest używany w HTML5");
        test.add("Tag: <strike> nie jest używany w HTML5");
        //assertEquals(list, test);
    }

}