package com.sionach.ux.keyWords;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by webownia on 29.09.16.
 */
public class KeywordsFromAnchor {
    public List<String> keywordsAnchor(String htmlCode){
        List<String> anchors = new ArrayList<>();
        String patternLink = "(?i)<a[^>]+>[^</a]+</a>";
        return anchors;
    }
}
