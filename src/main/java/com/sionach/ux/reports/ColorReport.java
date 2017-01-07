package com.sionach.ux.reports;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ColorReport {

    @PersistenceContext
    EntityManager entityManager;

    public List<Color> getColorsWithCounter() {

        List<Color> colors = entityManager.createQuery(
                "SELECT NEW com.sionach.ux.reports.Color(c.colors, count(c) as count)" +
                        " FROM Colors c GROUP BY c.colors").getResultList();

        return colors;
    }
}
