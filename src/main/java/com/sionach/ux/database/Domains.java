package com.sionach.ux.database;

/**
 * Created by allic on 11/12/2016.
 */
public class Domains {
    private int id;
    private int user_id;
    private String domain_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
