package com.sionach.ux.color;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ablazejewska on 20.11.16.
 */
@Entity
public class DistHex {

    public void setDistinctHex(Set<String> distinctHex) {
        this.distinctHex = distinctHex;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    private Set<String> distinctHex = new HashSet<>();


    public Set<String> getDistinctHex() {
        return distinctHex;
    }

    public Long getId() {
        return id;
    }
}
