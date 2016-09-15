package com.sionach.ux.csslists;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by webownia on 15.09.16.
 */
public class CssListFromHtml {
    private List<String> codeInlineList = new ArrayList<String>();
    private List<String> codeHeadList = new ArrayList<>();

    public List<String> getCodeInlineList(String htmlCode){
        String patternStyle = "(?i)style\\=\"[^\"]*\""; //wzór do pobrania kodu css w tagach html

        Pattern p = Pattern.compile(patternStyle);
        Matcher m = p.matcher(htmlCode);
        while(m.find()){
            //codeList.add(m.group());
            codeInlineList.add(m.group().replaceAll("style\\=\"","").replaceAll("\"",""));
        }

        return codeInlineList;
    }

    public List<String> getCodeHeadList(String htmlCode){

        String patternStyle = "(?i)<style[^<]*</style>"; //wzór do pobrania kodu css w tagach style

        Pattern p = Pattern.compile(patternStyle);
        Matcher m = p.matcher(htmlCode);
        while(m.find()){
            //codeList.add(m.group());
            codeHeadList.add(m.group().replaceAll("<style[^>]*>","").replaceAll("</style>",""));
        }

        return codeHeadList;
    }
}
