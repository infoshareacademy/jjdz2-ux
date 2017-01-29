package com.sionach.ux.synchronization;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by allic on 12/12/2016.
 */
public class DataBaseManager{
    // singleton, moze miec tylko jedna instancje, dba o to aby wywolana sesja nie byla powielona
    private static DataBaseManager instance;
    private EntityManagerFactory emf;
    private DataBaseManager(){};

    public synchronized static DataBaseManager getManager(){
        if (instance == null)
            instance = new DataBaseManager();
        return instance;
    }

    public EntityManagerFactory createEntityManagerFactory(){
        if (emf == null)
            emf = Persistence.createEntityManagerFactory("Pojedyncza sesja");
        return emf;
    }

    public EntityManager createEntityManager(){
        return this.createEntityManagerFactory().createEntityManager();
    }

    public void closeEntityManagerFactory(){
        if (emf != null)
            emf.close();
    }
}
