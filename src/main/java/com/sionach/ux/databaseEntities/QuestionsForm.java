package com.sionach.ux.databaseEntities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by allic on 11/12/2016.
 */
@Entity
@Table(name="questions_form")
public class QuestionsForm implements Serializable{
    @Column(name="question_id")
    private int question_id;
    @Column(name="user_id")
    private int user_id;
    @Column(name="answer")
    private int answer;

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getUse_id() {
        return user_id;
    }

    public void setUse_id(int use_id) {
        this.user_id = use_id;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return id;
    }
}
