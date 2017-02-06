package com.sionach.ux.databaseEntities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Created by drzalek on 29.01.17.
 */
@Stateless
public class DomainsDAO {
    @PersistenceContext
    EntityManager entityManager;

    public void save(String domainUrl, int userId){
        Domains domains = new Domains();
        domains.setDomain_url(domainUrl);
        domains.setUser_id(userId);
        entityManager.persist(domains);
    }

    public void saveNewDomain(String domainUrl, int userId){
        try{
            Domains domains = entityManager.createQuery("SELECT d FROM Domains d WHERE d.domain_url = '"+domainUrl+"' AND d.user_id = "+userId, Domains.class).getSingleResult();
        }catch(NoResultException e){
            save(domainUrl,userId);
        }
    }

    public Long domainIdByUrlAndUserId(String url, int userId){
        Domains domains = entityManager.createQuery("SELECT d FROM Domains d WHERE d.domain_url = '" + url + "' AND d.user_id = " + userId, Domains.class).getSingleResult();
        return domains.getId();
    }
}
