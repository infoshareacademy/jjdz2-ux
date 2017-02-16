package com.sionach.ux.databaseEntities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    public int saveAndReturnDomainId(String domainUrl, int userId){
        FavDomains domains = new FavDomains();
        domains.setDomain_url(domainUrl);
        domains.setUser_id(userId);
        entityManager.persist(domains);
        return domains.getId().intValue();
    }

    public void saveNewFavDomains(String domainUrl, int userId){
        try{
            FavDomains favDomains = entityManager.createQuery("SELECT f FROM FavDomains f WHERE f.user_id = :userid AND f.domain_url = :domain", FavDomains.class).setParameter("userid", userId).setParameter("domain", domainUrl).getSingleResult();
        }catch (NoResultException e){
            saveFavDomain(domainUrl,userId);
        }
    }

    public List<FavDomains> favDomainsByUserId(int userId){

        List<FavDomains>  favDomains= entityManager.createQuery("SELECT f FROM FavDomains f WHERE f.user_id = :userid", FavDomains.class).setParameter("userid", userId).getResultList();
        return favDomains;
    }

    public int favDomainInByUserIdAndUrl(int userId, String url){
        try{
            FavDomains favDomains = entityManager.createQuery("SELECT f FROM FavDomains f WHERE f.user_id = :userid AND f.domain_url = :url", FavDomains.class).setParameter("userid", userId).setParameter("url", url).getSingleResult();
            return favDomains.getId().intValue();
        }catch (NoResultException e){
            return saveAndReturnDomainId(url, userId);
        }
    }
}
