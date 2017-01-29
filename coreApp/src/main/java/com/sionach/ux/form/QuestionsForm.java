package com.sionach.ux.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public class QuestionsForm {

    public List<Question> questionsAndAnswers;

    @JsonDeserialize(as=List.class)
    @JsonProperty("questions")
    public List<Question> getQuestionsAndAnswers() {
        return questionsAndAnswers;
    }

    public void setQuestionsAndAnswers(List<Question> questionsAndAnswers) {
        this.questionsAndAnswers = questionsAndAnswers;
    }
}
