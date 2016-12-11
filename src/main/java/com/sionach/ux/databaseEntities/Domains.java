package com.sionach.ux.databaseEntities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by allic on 11/12/2016.
 */
@Entity
@Table(name="domains")
public class Domains implements Serializable{
    @Column(name="user_id")
    private int user_id;
    @Column(name="domain_url")
    private String domain_url;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDomain_url() {
        return domain_url;
    }

    public void setDomain_url(String domain_url) {
        this.domain_url = domain_url;
    }

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
