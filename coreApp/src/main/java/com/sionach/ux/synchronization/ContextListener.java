package com.sionach.ux.synchronization;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by allic on 12/12/2016.
 */
public class ContextListener implements ServletContextListener{
    public void contextInitialized(ServletContextEvent event){
        DataBaseManager.getManager().createEntityManagerFactory();
    }

    public void contextDestroyed(ServletContextEvent event){
        DataBaseManager.getManager().closeEntityManagerFactory();
    }
}
