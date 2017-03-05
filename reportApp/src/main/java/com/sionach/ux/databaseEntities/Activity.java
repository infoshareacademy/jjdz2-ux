package com.sionach.ux.databaseEntities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by allic on 11/12/2016.
 */
@Entity
@Table(name="activity")
public class Activity implements Serializable{
//    @ManyToOne
//    @Column(name="userId")
//    private String userId;

    @Column(name="dateOfLogin")
    private Long dateOfLogin;

    @Column(name="user_name")
    private String userName;

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return id;
    }


    public Long getDateOfLogin() {
        return dateOfLogin;
    }

    public void setDateOfLogin(Long dateOfLogin) {
        this.dateOfLogin = dateOfLogin;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
