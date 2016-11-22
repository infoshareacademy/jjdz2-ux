package com.sionach.ux.form;

import com.sionach.ux.filemanagment.ReadFiles;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class PageValidationForm {

    @EJB
    ReadFiles readFiles;

    private Map<String, String> answerMap = new HashMap<>();
    private String fileWithAnswers = "answerMap";

    public Map<String, String> generateAnswers(Map<String, String[]> formAnswers){

        Map<String, List<String>> fileAnswers = readFiles.readFileToMapWith2Values(fileWithAnswers);
        for(Map.Entry<String, String[]> item:formAnswers.entrySet()){

            List<String> answears = fileAnswers.get(item.getKey());

            if(item.getValue()[0].equals("0")){
                answerMap.put(item.getKey(), answears.get(0));
            } else {
                answerMap.put(item.getKey(), answears.get(1));
            }

        }
        System.out.println(fileAnswers);
        return answerMap;
    }
}
