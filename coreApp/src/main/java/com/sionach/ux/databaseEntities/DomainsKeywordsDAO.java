package com.sionach.ux.databaseEntities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class DomainsKeywordsDAO {
    @PersistenceContext
    EntityManager entityManager;

    public void saveKeyword(String keyword, int domainId){
        DomainsKeywords domainsKeywords = new DomainsKeywords();
        domainsKeywords.setDomain_id(domainId);
        domainsKeywords.setKeywords(keyword);
        entityManager.persist(domainsKeywords);
        System.out.println("zapis do bazy: id-domeny: "+domainId+" slowo kluczowe: "+keyword);
    }

    public String saveKeywordOrDelete(String keyword, int domainId){
        try{
            DomainsKeywords domainsKeywords = entityManager.createQuery("SELECT d FROM DomainsKeywords d WHERE d.domain_id = "+domainId+" AND d.keywords = '"+keyword+"'", DomainsKeywords.class).getSingleResult();
            Long keywordsId = domainsKeywords.getId();
            if(keywordsId > 0){
                entityManager.createQuery("DELETE FROM DomainsKeywords d WHERE d.domain_id = "+domainId+" AND d.keywords = '"+keyword+"'").executeUpdate();
                return "-1";
            }
            return "0";

        }catch(NoResultException e){
            saveKeyword(keyword, domainId);
            return "1";
        }
    }

    public boolean isKeywordInDatabase(String keyword, int domainId){
        try{
            DomainsKeywords domainsKeywords = entityManager.createQuery("SELECT d FROM DomainsKeywords d WHERE d.domain_id = "+domainId+" AND d.keywords = '"+keyword+"'", DomainsKeywords.class).getSingleResult();
            Long keywordsId = domainsKeywords.getId();
            if(keywordsId>0){
                return true;
            }else{
                return false;
            }

        }catch (NoResultException e){
            return false;
        }
    }


}
