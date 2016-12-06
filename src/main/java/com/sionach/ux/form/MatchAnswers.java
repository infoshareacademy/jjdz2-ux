package com.sionach.ux.form;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MatchAnswers {

    public List<String> getAnswers(Map<String, String[]> parameters) {

        QuestionsJsonReader qJsonReader = new QuestionsJsonReader();
        List<QuestionForm> questions = qJsonReader.readJsonFile();
        List<String> answers = new LinkedList<>();

        for (QuestionForm item : questions) {

            answers.add(item.getAnswers().getAnswerByOption(parameters.get(String.valueOf(item.getKey()))[0]));
        }

        return answers;
    }
}
