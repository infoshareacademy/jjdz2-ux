package com.sionach.ux.databaseEntities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by ablazejewska on 18.12.16.
 */
@Stateless
public class RoutingDAO {
    @PersistenceContext
    EntityManager entityManager;

    private static final Logger LOGGER = LogManager.getLogger(RoutingDAO.class);

    public void save(int domainId, String link, int type){
        Routing routing = new Routing();
        routing.setDomain_id(domainId);
        routing.setLink(link);
        routing.setType(type);
        entityManager.persist(routing);

    }

    public void readSomething(){
//        List<String> userId = entityManager.createQuery("SELECT d.facebookId FROM Activity d", String.class).getResultList();
//        System.out.println(userId);
//        LOGGER.info("Odczyt z bazy wykonany dla fb id");
    }
}
