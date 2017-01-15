package com.sionach.ux.facebook;

import com.github.scribejava.core.oauth.OAuth20Service;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Locale;

@SessionScoped
public class SessionData implements Serializable {

    private boolean isLogged = false;
    private String username;
    private LocalDate loginTime;
    private OAuth20Service oAuthService;
    private Locale locale;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDate loginTime) {
        this.loginTime = loginTime;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public OAuth20Service getOAuthService() {
        return oAuthService;
    }

    public void setOAuthService(OAuth20Service oAuthService) {
        this.oAuthService = oAuthService;
    }

//    public void login(String username, String password) {
//
//        if ("kuba".equals(username) && "secret".equals(password)) {
//            System.out.println("User [" + username + "] logged in");
//            this.isLogged = true;
//            this.username = username;
//            this.loginTime = LocalDate.now();
//        }
//
//        System.out.println("Login failed: " + username);
//
//    }

    public void logout() {
        this.isLogged = false;
        this.username = "";
        this.loginTime = null;
    }

}