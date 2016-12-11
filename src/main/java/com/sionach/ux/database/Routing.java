package com.sionach.ux.database;

/**
 * Created by allic on 11/12/2016.
 */
public class Routing {
    private int domain_id;
    private String link;
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
}
