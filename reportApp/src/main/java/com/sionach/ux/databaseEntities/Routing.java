package com.sionach.ux.databaseEntities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="routing")
public class Routing implements Serializable{
    @Column(name = "link")
    private String link;
    @Column(name = "innerLinks")
    private int innerlinks;
    @Column(name = "outerLinks")
    private int outerLinks;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getInnerlinks() {
        return innerlinks;
    }

    public void setInnerlinks(int innerlinks) {
        this.innerlinks = innerlinks;
    }

    public int getOuterLinks() {
        return outerLinks;
    }

    public void setOuterLinks(int outerLinks) {
        this.outerLinks = outerLinks;
    }

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return id;
    }
}
