package com.sionach.ux.keyWords;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allic on 14/10/2016.
 */
public class KeywordsFromMetadata {

    public List<String> MetadataKeywords(String htmlCode) {
        Document doc = Jsoup.parse(htmlCode);
        Elements elements = doc.select("meta");
        List<String> metaList = new ArrayList<>();

        for (Element item : elements) {
            if (item.attr("charset").length() > 0) {
                metaList.add(item.attr("charset"));
            }
            if (item.attr("content").length() > 0) {
                metaList.add(item.attr("content"));
            }

            if (item.attr("http-equiv").length() > 0) {
                metaList.add(item.attr("http-equiv"));
            }

            if (item.attr("name").length() > 0) {
                metaList.add(item.attr("name"));
            }

            if (item.attr("scheme").length() > 0) {
                metaList.add(item.attr("scheme"));
            }

        }

        return metaList;
    }
}
