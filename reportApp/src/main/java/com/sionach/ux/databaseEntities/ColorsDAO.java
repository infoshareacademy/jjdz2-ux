package com.sionach.ux.databaseEntities;

/**
 * Created by ablazejewska on 18.12.16.
 */

//import com.sionach.ux.color.DistHex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Stateless
public class ColorsDAO {

    @PersistenceContext
    EntityManager entityManager;

    private static final Logger LOGGER = LogManager.getLogger(ColorsDAO.class);

    public void save(Set<String> distHex){
        for (String hex: distHex) {
            Colors colors = new Colors();
            colors.setColors(hex);
            colors.setDomain_id(22364);
            colors.setTest_date(new Date());
            entityManager.persist(colors);
            LOGGER.info("Zapis do bazy dokonany");
        }
    }

    public void readColors(){
        List<String> colores = entityManager.createQuery("SELECT d.colors FROM Colors d", String.class).getResultList();
        System.out.println(colores);
        LOGGER.info("Odczyt z bazy wykonany");
    }

}


