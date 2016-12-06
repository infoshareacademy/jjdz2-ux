package com.sionach.ux.form;

public class QuestionForm {

    private int key;
    private String title;
    private AnswerForm answers;


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AnswerForm getAnswers() {
        return answers;
    }

    public void setAnswers(AnswerForm answers) {
        this.answers = answers;
    }
}
