package com.sionach.ux.databaseEntities;

import com.sun.xml.internal.ws.developer.UsesJAXBContext;

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
    @Column(name="email")
    private String email;
    @Column(name="role")
    private int role;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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
