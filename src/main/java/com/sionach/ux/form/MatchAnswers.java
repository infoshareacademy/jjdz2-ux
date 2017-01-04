package com.sionach.ux.form;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Stateless
public class MatchAnswers {

    @EJB
    QuestionsJsonReader qJsonReader;

    public List<String> getAnswers(Map<String, String[]> parameters) {

        List<String> answers = new LinkedList<>();

        List<Question> questionsForm = qJsonReader.getQuestionsForm().getQuestionsAndAnswers();

        for (Question item : questionsForm) {
            answers.add(item.getKey() + item.getTitle());
            for (Answer answer : item.getAnswers()) {
                if (parameters.get(String.valueOf(item.getKey()))[0].equals(String.valueOf(answer.getOption()))) {
                    answers.add(String.valueOf(answer.getOption()) + answer.getAnswer());
                }
            }
        }
        return answers;
    }
}
