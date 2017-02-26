package com.sionach.ux.databaseEntities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by allic on 11/12/2016.
 */
@Entity
@Table(name="Activity")
public class Activity implements Serializable{
//    @ManyToOne
//    @Column(name="userId")
//    private String userId;

    @Column(name="dateOfLogin")
    private Date dateOfLogin;

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return id;
    }


    public Date getDateOfLogin() {
        return dateOfLogin;
    }

    public void setDateOfLogin(Date dateOfLogin) {
        this.dateOfLogin = dateOfLogin;
    }


}
