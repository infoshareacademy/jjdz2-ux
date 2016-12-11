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
@Table(name="colors")
public class Colors implements Serializable{
    @Column(name="domain_id")
    private int domain_id;
    @Column(name="colors")
    private String colors;
    @Column(name="test-date")
    private String test_date;

    public int getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(int domain_id) {
        this.domain_id = domain_id;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getTest_date() {
        return test_date;
    }

    public void setTest_date(String test_date) {
        this.test_date = test_date;
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
