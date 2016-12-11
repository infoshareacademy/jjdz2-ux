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
@Table(name="routing")
public class Routing implements Serializable{
    @Column(name="domain_id")
    private int domain_id;
    @Column(name = "link")
    private String link;
    @Column(name = "type")
    private int type;

    public int getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(int domain_id) {
        this.domain_id = domain_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
