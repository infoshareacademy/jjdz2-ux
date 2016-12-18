package com.sionach.ux.facebook;

import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.User;
import facebook4j.auth.AccessToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by ablazejewska on 10.12.16.
 */

@WebServlet(urlPatterns = "/callback")
public class FacebookCallback extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(FacebookCallback.class);

    public static final String API_KEY = "339512966407211";
    public static final String API_SECRET = "f3f144e2ef310fbbf507f8ed8dac0e7c";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OAuth20Service service = new ServiceBuilder()
                .apiKey(API_KEY)
                .apiSecret(API_SECRET)
                .callback("http://localhost:8080/sionach-ux/callback")
                .build(FacebookApi.instance());

        String code = req.getParameter("code");
        System.out.println(code);

        //TODO tutaj lub w oddzielnej klasie
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId(API_KEY,API_SECRET);
        try {
            //facebook.getOAuthAppAccessToken();
            facebook.setOAuthAccessToken(new AccessToken("9ddaa99271ad0cdda928ebbf3279080e",null));
            User me = facebook.getMe();
            String name = me.getFirstName();
            String surname = me.getLastName();
            String email = me.getEmail();
            LOGGER.info("name: " + name + ", surname: " + surname, ", email: " + email);

        } catch (FacebookException e) {
            e.printStackTrace();
        }



    }



}
