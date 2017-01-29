package com.sionach.ux.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {

    private String answer;
    private int option;

    @JsonProperty("answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @JsonProperty("option")
    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }
}
