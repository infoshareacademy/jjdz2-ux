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

        for (String item : formQuestionsAndAnswers) {
            QuestionsForm questionsForm = new QuestionsForm();
            if (item.contains("?")) {
                LOGGER.debug("PYTANIE###    " + item.substring(0, 1));
                questionsForm.setQuestion_id(Integer.parseInt(item.substring(0, 1)));
            } else {
                LOGGER.debug("ODPOWIEDŹ#    " + item.substring(0, 1));
                questionsForm.setAnswer(Integer.parseInt(item.substring(0, 1)));
            }
            entityManager.persist(questionsForm);
        }
        LOGGER.info("Zapis do bazy danych");
    }

    public void readForm() {

        List<QuestionsForm> items =  entityManager.createQuery("SELECT d FROM QuestionsForm d").getResultList();

        for (QuestionsForm item : items){

            System.out.println(item.toString());
        }
        LOGGER.info("Odczyt z bazy danych");
    }
}
