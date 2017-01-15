import com.sionach.ux.facebook.SessionData;
import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/google")
public class FacebookRedirect extends HttpServlet {

    private static final String CLIENT_ID = "502207594632-9vfi2sfnh07j9ft682id5d53njsdkado.apps.googleusercontent.com";
    private static final String CLIENT_SECRET = "Nk4gKXQBexMIwPZYnfNZmdt5";

    @Inject
    SessionData sessionData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OAuth20Service service = new ServiceBuilder()
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback("http://localhost:8080/google-oauth-callback")
                .scope("openid profile email " +
                        "https://www.googleapis.com/auth/plus.login " +
                        "https://www.googleapis.com/auth/plus.me")
                .build(GoogleApi20.instance());

        sessionData.setOAuthService(service);

        resp.sendRedirect(service.getAuthorizationUrl());
    }
}