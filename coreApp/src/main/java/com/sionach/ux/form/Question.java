package com.sionach.ux.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

public class Question {

    private int key;

    private String title;

    private List<Answer> answers;

    @JsonProperty("key")
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonDeserialize(as=List.class)
    @JsonProperty("options")
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
