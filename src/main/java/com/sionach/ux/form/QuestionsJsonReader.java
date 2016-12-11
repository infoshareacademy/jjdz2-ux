package com.sionach.ux.form;



import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.Stateless;
import java.io.File;
import java.io.IOException;


@Stateless
public class QuestionsJsonReader {

    public static final String JSON_FILE = "target/classes/answerMap.json";

    public QuestionsForm readJsonFile() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        QuestionsForm questionsForm = objectMapper.readValue(new File(JSON_FILE), QuestionsForm.class);

        return questionsForm;
    }
}
