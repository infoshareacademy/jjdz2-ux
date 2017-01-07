package com.sionach.ux.facebook;

/**
 * Created by ablazejewska on 10.12.16.
 */
import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.oauth.OAuth20Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by keehoo on 27.11.16.
 */
@WebServlet(urlPatterns = "/facebook")
public class FacebookLogin extends HttpServlet {

    private static final String NETWORK_NAME = "Facebook";
    public static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
    public static final Token EMPTY_TOKEN = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OAuth20Service service = new ServiceBuilder()
                .apiKey("339512966407211")
                .apiSecret("f3f144e2ef310fbbf507f8ed8dac0e7c")
                .callback("http://localhost:8080/sionach-ux")
                .build(FacebookApi.instance());

        String authorizationUrl=service.getAuthorizationUrl();
        System.out.println("Authorization URL : "+authorizationUrl);

        resp.sendRedirect(authorizationUrl);

    }
}