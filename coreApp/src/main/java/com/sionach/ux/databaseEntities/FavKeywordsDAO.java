package com.sionach.ux.databaseEntities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Created by drzalek on 06.02.2017.
 */
@Stateless
public class FavKeywordsDAO {

    @PersistenceContext
    EntityManager entityManager;

    public void saveFavKeyword(String keyword, int favDomainId){
        FavKeywords favKeywords = new FavKeywords();
        favKeywords.setKeywords(keyword);
        favKeywords.setDomain_id(favDomainId);
        entityManager.persist(favKeywords);
    }

    public void saveNewFavKeyword(String keyword, int favDomainId){
        try{
            FavKeywords favKeywords = entityManager.createQuery("SELECT f FROM FavKeywords f WHERE f.domain_id = :domain AND f.keywords = :keywords", FavKeywords.class).setParameter("domain", favDomainId).setParameter("keywords", keyword).getSingleResult();
        }catch (NoResultException e){
            saveFavKeyword(keyword,favDomainId);
        }
    }
}
