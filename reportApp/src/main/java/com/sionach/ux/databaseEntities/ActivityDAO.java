package com.sionach.ux.databaseEntities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by ablazejewska on 18.12.16.
 */
@Stateless
public class ActivityDAO {
    @PersistenceContext
    EntityManager entityManager;

    private static final Logger LOGGER = LogManager.getLogger(ActivityDAO.class);

    public void save(String userName, Long dateOfLogin){
        Activity activity = new Activity();
        activity.setDateOfLogin(dateOfLogin);
        activity.setUserName(userName);
        entityManager.persist(activity);

    }

    public List<Activity> readUserId(){
        List<Activity> userId = entityManager.createQuery("SELECT d FROM Activity d", Activity.class).getResultList();
        //System.out.println(userId);
        LOGGER.info("Odczyt z bazy wykonany dla fb id");
        return userId;

    }
}
