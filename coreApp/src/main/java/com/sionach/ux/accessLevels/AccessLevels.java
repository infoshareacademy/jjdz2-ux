package com.sionach.ux.accessLevels;

/**
 * Created by ablazejewska on 26.02.17.
 */
public enum AccessLevels {
    ADMIN(true),
    NORMAL(false);

    boolean admin;

    private AccessLevels(boolean isAdmin){
        admin = isAdmin;
    }

}
