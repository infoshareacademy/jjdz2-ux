package com.sionach.ux.form;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MatchAnswers {

    public List<String> getAnswers(Map<String, String[]> parameters) {

        QuestionsJsonReader qJsonReader = new QuestionsJsonReader();
        QuestionsForm questions = new QuestionsForm();
        try {
            questions = qJsonReader.readJsonFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> answers = new LinkedList<>();

//        for (QuestionsForm item : questions) {
//
//            answers.add(item.getTitle());
//            answers.add(item.getAnswers().getAnswerByOption(parameters.get(String.valueOf(item.getKey()))[0]));
//        }

        System.out.println(questions);

        return answers;
    }
}
