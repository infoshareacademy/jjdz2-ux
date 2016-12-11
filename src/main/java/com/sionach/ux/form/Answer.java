package com.sionach.ux.form;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {

    private String answer;

    @JsonProperty("answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
