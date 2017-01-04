package com.sionach.ux.databaseEntities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class QuestionsFormDAO {

    @PersistenceContext
    EntityManager entityManager;

    public void saveForm(List<String> formQuestionsAndAnswers) {
        for (String item : formQuestionsAndAnswers) {
            QuestionsForm questionsForm = new QuestionsForm();
            if (item.contains("?")) {
                System.out.println("PYTANIE###    " + item.substring(0, 1));
                questionsForm.setQuestion_id(Integer.parseInt(item.substring(0, 1)));
            } else {
                System.out.println("ODPOWIEDŹ#    " + item.substring(0, 1));
                questionsForm.setAnswer(Integer.parseInt(item.substring(0, 1)));
            }
            entityManager.persist(questionsForm);
        }
    }

    public void readForm() {
        //?????
        List items =  entityManager.createQuery("SELECT d FROM QuestionsForm d").getResultList();
    }
}
