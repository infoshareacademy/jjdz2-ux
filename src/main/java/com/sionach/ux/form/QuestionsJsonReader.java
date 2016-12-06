package com.sionach.ux.form;

import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;


@Stateless
public class QuestionsJsonReader {

    public static final String JSON_FILE = "target/classes/answerMap.json";

//    public QuestionForm readJsonFile() throws IOException{
//
//        InputStream file = new FileInputStream(JSON_FILE);
//        System.out.println("file.read() " + file.read());
//
//        JsonReader jsonReader = Json.createReader(file);
//
//        System.out.println("jsonReader " + jsonReader);
//        JsonObject jsonObject = jsonReader.readObject();
//        System.out.println(jsonObject.isNull("key"));
//        jsonReader.close();
//        file.close();
//
//        System.out.println(jsonObject.getString("key"));
//
//        QuestionForm questionForm = new QuestionForm();
//        System.out.println(questionForm);
//
//        questionForm.setKey(jsonObject.getString("key"));
//        questionForm.setTitle(jsonObject.getString("title"));

//        JsonObject innerJsonObject = jsonObject.getJsonObject("options");
//        AnswerForm answerForm = new AnswerForm();
//        answerForm.setAnswer1(innerJsonObject.getString("answer1"));
//        answerForm.setAnswer1(innerJsonObject.getString("answer2"));
//
//        questionForm.setAnswers(answerForm);

//        return questionForm;
//    }


    public List<QuestionForm> readJsonFile() {

        List<QuestionForm> questions = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            QuestionForm questionForm = new QuestionForm();
            questionForm.setKey(i);
            questionForm.setTitle("question" + i);
            AnswerForm answerForm = new AnswerForm();
            answerForm.setAnswer1("answer1");
            answerForm.setAnswer2("answer2");
            questionForm.setAnswers(answerForm);
            questions.add(questionForm);
        }
        return questions;
    }
}
