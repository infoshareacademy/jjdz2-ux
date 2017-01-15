package com.sionach.ux.reports;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ColorReport {

    @PersistenceContext
    EntityManager entityManager;

    public List<Color> getColorsWithCounter() {

        List<Color> colors = entityManager.createQuery(
                "SELECT NEW com.sionach.ux.reports.Color(c.colors, count(c) as count)" +
                        " FROM Colors c GROUP BY c.colors").getResultList();

        return colors.stream().
                sorted((color1, color2) -> Long.compare(color2.getCount(), color1.getCount())).
                collect(Collectors.toList());
    }
}

