package com.sionach.ux.databaseEntities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by allic on 11/12/2016.
 */
@Entity
@Table(name="accessibility")
public class Accessibility implements Serializable{
    @Column(name="domain_id",unique = false)
    private int domain_id;

    @Column(name="recommendation",unique = false)
    private String recommendation;

    public int getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(int domain_id) {
        this.domain_id = domain_id;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }


    private String id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
