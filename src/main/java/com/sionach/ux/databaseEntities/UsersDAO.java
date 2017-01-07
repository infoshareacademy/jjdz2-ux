package com.sionach.ux.databaseEntities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by ablazejewska on 18.12.16.
 */
@Stateless
public class UsersDAO {
    @PersistenceContext
    EntityManager entityManager;

    private static final Logger LOGGER = LogManager.getLogger(UsersDAO.class);

    public void save(){

    }

    public void readUsers(){

    }
}
