package com.sionach.ux.accessibility;

import com.sionach.ux.filemanagment.ReadFiles;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by webownia on 10.10.16.
 */
public class DeprecatedTagsInHtml {

    public List<String> findDeprecatedTags(String htmlCode) throws FileNotFoundException {
        List<String> deprecatedTags = new ArrayList<>();
        Document doc = Jsoup.parse(htmlCode);

        DeprecatedTagsList deprecatedHtmlTags = new DeprecatedTagsList();
        List<String> deprecatedTagsList = deprecatedHtmlTags.createDeprecatedTagsList("src/main/resources/deprecatedTags.txt");
        for(String item:deprecatedTagsList) {
            Elements elements = doc.select(item);
            if(elements.size()>0){
                deprecatedTags.add("Tag: <"+item+"> nie jest używany w HTML5");
            }
        }
        return  deprecatedTags;
    }

}
