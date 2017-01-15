/**
 * Created by ablazejewska on 10.12.16.
 */
import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.sionach.ux.facebook.SessionData;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by keehoo on 27.11.16.
 */
@WebServlet(urlPatterns = "/facebooklogin")
public class FacebookLogin extends HttpServlet {

    @Inject
    SessionData sessionData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OAuth20Service service = new ServiceBuilder()
                .apiKey("339512966407211")
                .apiSecret("f3f144e2ef310fbbf507f8ed8dac0e7c")
                .callback("http://localhost:8080/sionach-ux")
                .build(FacebookApi.instance());

        sessionData.setOAuthService(service);
        resp.sendRedirect(service.getAuthorizationUrl());

    }
}