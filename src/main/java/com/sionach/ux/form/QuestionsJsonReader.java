package com.sionach.ux.form;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.IOException;

@Startup
@Singleton
public class QuestionsJsonReader {

    private QuestionsForm questionsForm;

    public static final String JSON_FILE_NAME = "answerMap.json";

    @PostConstruct
    public void readJsonFile() {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            questionsForm = objectMapper.readValue(QuestionsJsonReader.class.getClassLoader().getResource(JSON_FILE_NAME), QuestionsForm.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public QuestionsForm getQuestionsForm() {
        return questionsForm;
    }
}
