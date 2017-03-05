package com.sionach.ux.databaseEntities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class RoutingDAO {
    @PersistenceContext
    EntityManager entityManager;

    public void save(String url, int innerLinks, int outerLinks){
        Routing routing = new Routing();
        routing.setLink(url);
        routing.setInnerlinks(innerLinks);
        routing.setOuterLinks(outerLinks);
        entityManager.persist(routing);
    }

    public void saveOnlyNew(String url, int innerLinks, int outerLinks){
        try {
            Routing routing = entityManager.createQuery("SELECT r FROM Routing r WHERE r.link =:url", Routing.class).setParameter("url", url).getSingleResult();
            routing.setOuterLinks(outerLinks);
            routing.setInnerlinks(innerLinks);
            routing.setLink(url);
            entityManager.persist(routing);
        }catch(NoResultException e){
            save(url, innerLinks, outerLinks);
        }
    }

    public List<Routing> read(){
        List<Routing> links = entityManager.createQuery("SELECT d FROM Routing d").getResultList();
        return links;
    }
}
