package com.sionach.ux.databaseEntities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class QuestionsFormDAO {

    private static final Logger LOGGER = LogManager.getLogger(QuestionsForm.class);
    @PersistenceContext
    EntityManager entityManager;

    public void saveForm(List<String> formQuestionsAndAnswers) {

        for(int i=0; i<formQuestionsAndAnswers.size(); i++){
            QuestionsForm questionsForm = new QuestionsForm();
            questionsForm.setQuestion_id(Integer.parseInt(formQuestionsAndAnswers.get(i).substring(0, 1)));
            questionsForm.setAnswer(Integer.parseInt(formQuestionsAndAnswers.get(i+1).substring(0, 1)));
            i++;
            entityManager.persist(questionsForm);
            LOGGER.info("Zapis do bazy danych");
        }
    }

    public void readForm() {

        List<QuestionsForm> items =  entityManager.createQuery("SELECT d FROM QuestionsForm d").getResultList();

        for (QuestionsForm item : items){

            System.out.println(item.toString());
        }
        LOGGER.info("Odczyt z bazy danych");
    }
}
