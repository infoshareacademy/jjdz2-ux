package com.sionach.ux.csslists;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by webownia on 15.09.16.
 */
public class CssListFromHtml {
    private List<String> codeList = new ArrayList<String>();

    public List<String> getCodeList(String htmlCode){
        String patternStyle = "(?i)style\\=\"[^\"]*\""; //wzór do pobrania kodu css w tagach html

        Pattern p = Pattern.compile(patternStyle);
        Matcher m = p.matcher(htmlCode);
        while(m.find()){
            //codeList.add(m.group());
            codeList.add(m.group().replaceAll("style\\=\"","").replaceAll("\"",""));
        }

        return codeList;
    }
}
