package com.sionach.ux.databaseEntities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by allic on 11/12/2016.
 */
@Entity
@Table(name="users")
public class Users implements Serializable{
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="role")
    private int role;
    @Column(name="facebookId")
    private String fBid;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return id;
    }

    public String getfBid() {
        return fBid;
    }

    public void setfBid(String fBid) {
        this.fBid = fBid;
    }

    @Override
    public String toString() {
        return "Users{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role=" + role +
                ", fBid='" + fBid + '\'' +
                ", id=" + id +
                '}';
    }
}
