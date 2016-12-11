package com.sionach.ux.databaseEntities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by allic on 11/12/2016.
 */
@Entity
@Table(name="domains_keywords")
public class DomainsKeywords implements Serializable{
    @Column(name="domain_id")
    private int domain_id;
    @Column(name="keywords")
    private String keywords;

    public int getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(int domain_id) {
        this.domain_id = domain_id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
