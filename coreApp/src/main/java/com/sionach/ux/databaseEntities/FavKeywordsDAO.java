package com.sionach.ux.databaseEntities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

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

    public void saveFavKeywordsList(String keywords, int favDomain){
        String[] keywordsList = keywords.split(",");
        for(String item:keywordsList){
            saveNewFavKeyword(item.trim(), favDomain);
        }
    }

    public List<FavKeywords> keywordsListByDomainId(int domainId){
        try{
            List<FavKeywords> favKeywords = entityManager.createQuery("SELECT f FROM FavKeywords f WHERE f.domain_id = :domainId", FavKeywords.class).setParameter("domainId", domainId).getResultList();
            return favKeywords;
        }catch (NoResultException e){
            return Collections.emptyList();
        }
    }

    public String ramoveKeyword(String keyword, int domainId){
        System.out.println("do usuniecia: "+keyword+" z domeny: "+domainId);
        try{
            FavKeywords favKeywords = entityManager.createQuery("SELECT f FROM FavKeywords f WHERE f.keywords = :keyword AND f.domain_id = :domainid", FavKeywords.class).setParameter("keyword", keyword).setParameter("domainid", domainId).getSingleResult();
            Long keywordId = favKeywords.getId();

            if(keywordId > 0){
                entityManager.createQuery("DELETE FROM FavKeywords f WHERE f.keywords = :keyword AND f.domain_id = :domainid").setParameter("keyword", keyword).setParameter("domainid", domainId).executeUpdate();
                return "1";
            }
            return "-1";
        }catch (NoResultException e){

            return "0";
        }

    }
}
