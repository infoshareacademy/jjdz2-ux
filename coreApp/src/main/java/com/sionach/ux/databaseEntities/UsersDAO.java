package com.sionach.ux.databaseEntities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Created by ablazejewska on 18.12.16.
 */
@Stateless
public class UsersDAO {
    @PersistenceContext
    EntityManager entityManager;

    private static final Logger LOGGER = LogManager.getLogger(UsersDAO.class);

    public Users save(String name, String id){
        Users users = new Users();
        users.setFirstname(name);
        users.setfBid(id);
        users.setRole(1);
        entityManager.persist(users);
        System.out.println("users = " + users);

        return users;
    }

    public Users readUser(String name, String id){
        System.out.println("facebookid= "+id);
        try{
            Users user = entityManager.createQuery("SELECT d FROM Users d WHERE d.fBid = '"+id+"'", Users.class).getSingleResult();
            return user;
        }catch (NoResultException e){
            Users user = save(name, id);
            return user;
        }

        //System.out.println("user z bazy "+user);
        //return user;
    }
//
//    public void readUsers(String fbid){
//        Users userName = entityManager.createQuery("SELECT d FROM Users d WHERE d.fBid = :fbid", Users.class)
//                .setParameter("fbid", fbid)
//                .getSingleResult();
//        System.out.println(userName);
//        LOGGER.info("Odczyt z bazy wykonany dla imienia");
//    }
//
//    public int getUserId(String fbid){
//        Integer userId = entityManager.createNativeQuery("SELECT id FROM Users WHERE facebookId = '"+fbid+"'", Integer.class).getFirstResult();
//        System.out.println(userId);
//        return userId;
//    }
}
