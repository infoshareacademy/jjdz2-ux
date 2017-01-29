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
public class UsersDAO {
    @PersistenceContext
    EntityManager entityManager;

    private static final Logger LOGGER = LogManager.getLogger(UsersDAO.class);

    public void save(String name, String id){
        Users users = new Users();
        users.setFirstname(name);
        users.setfBid(id);
        users.setRole(1);
        entityManager.persist(users);

    }

    public void readUsers(){
        List<String> userName = entityManager.createQuery("SELECT d.firstname FROM Users d", String.class).getResultList();
        System.out.println(userName);
        LOGGER.info("Odczyt z bazy wykonany dla imienia");
    }
}
