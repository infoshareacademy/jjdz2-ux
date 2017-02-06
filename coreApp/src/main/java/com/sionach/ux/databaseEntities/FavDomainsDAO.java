package com.sionach.ux.databaseEntities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Created by drzalek on 06.02.2017.
 */
@Stateless
public class FavDomainsDAO {
    @PersistenceContext
    EntityManager entityManager;

    public void saveFavDomain(String domainUrl, int userId){
        FavDomains favDomains = new FavDomains();
        favDomains.setUser_id(userId);
        favDomains.setDomain_url(domainUrl);
        entityManager.persist(favDomains);

    }

    public void saveNewFavDomains(String domainUrl, int userId){
        try{
            FavDomains favDomains = entityManager.createQuery("SELECT f FROM FavDomains f WHERE f.user_id = :userid AND f.domain_url = :domain", FavDomains.class).setParameter("userid", userId).setParameter("domain", domainUrl).getSingleResult();
        }catch (NoResultException e){
            saveFavDomain(domainUrl,userId);
        }
    }
}
