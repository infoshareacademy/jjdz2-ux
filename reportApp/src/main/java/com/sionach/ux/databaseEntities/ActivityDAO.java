package com.sionach.ux.databaseEntities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.sql.Date;
import java.util.List;

/**
 * Created by ablazejewska on 18.12.16.
 */
@Stateless
public class ActivityDAO {
    @PersistenceContext
    EntityManager entityManager;

    private static final Logger LOGGER = LogManager.getLogger(ActivityDAO.class);

    public void save(String fbId, Long dateOfLogin){
        Activity activity = new Activity();
        activity.setUserId(fbId);
        activity.setDateOfLogin(dateOfLogin);
        entityManager.persist(activity);

    }

    public List<Long> readUserId(){
        List<Long> userId = entityManager.createQuery("SELECT d.dateOfLogin FROM Activity d", Long.class).getResultList();
        LOGGER.info("Odczyt z bazy wykonany dla fb id");
        return userId;

    }
}
