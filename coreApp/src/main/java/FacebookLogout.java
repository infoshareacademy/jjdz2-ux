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
 * Created by ablazejewska on 29.01.17.
 */

    @WebServlet(urlPatterns = "/facebooklogout")
    public class FacebookLogout extends HttpServlet {

        @Inject
        SessionData sessionData;

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            sessionData.logout();
            resp.sendRedirect("/sionach-ux");
        }
    }
