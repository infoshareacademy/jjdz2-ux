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

        for (Question item : questions.getQuestionsAndAnswers()) {
            answers.add(item.getTitle());
            for (Answer answer : item.getAnswers()) {
                if (parameters.get(String.valueOf(item.getKey()))[0].equals(String.valueOf(answer.getOption()))) {
                    answers.add(answer.getAnswer());
                }
            }
        }
        return answers;
    }
}
