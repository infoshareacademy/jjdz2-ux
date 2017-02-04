package com.sionach.ux.databaseEntities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
}
