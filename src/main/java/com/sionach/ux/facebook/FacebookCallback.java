package com.sionach.ux.facebook;

import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.github.scribejava.core.oauth.OAuthService;

import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by ablazejewska on 10.12.16.
 */

@WebServlet(urlPatterns = "/callback")
public class FacebookCallback extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OAuth20Service service = new ServiceBuilder()
                .apiKey("339512966407211")
                .apiSecret("f3f144e2ef310fbbf507f8ed8dac0e7c")
                .callback("http://localhost:8080/sionach-ux/callback")
                .build(FacebookApi.instance());

        String code = req.getParameter("code");
        System.out.println(code);


    }
}
