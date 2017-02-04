import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.sionach.ux.databaseEntities.Users;
import com.sionach.ux.databaseEntities.UsersDAO;
import com.sionach.ux.facebook.SessionData;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by ablazejewska on 15.01.17.
 */
@WebServlet(urlPatterns = "/fbcallback")
public class FacebookCallback extends HttpServlet {

    @Inject
    SessionData sessionData;

    @Inject
    UsersDAO usersDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final OAuth20Service oAuthService = sessionData.getOAuthService();
        final String code = req.getParameter("code");// Access code with token

        OAuthRequest oAuthRequest = new OAuthRequest(Verb.GET, "https://graph.facebook.com/me",
                oAuthService.getConfig());

        oAuthService.signRequest(oAuthService.getAccessToken(code), oAuthRequest);
        Response oAuthResp = oAuthRequest.send();

        JsonReader reader = Json.createReader(new StringReader(oAuthResp.getBody()));
        JsonObject profile = reader.readObject();
        String name = profile.getString("name");
        String id = profile.getString("id");

        Users user = usersDAO.save(name, id);
//        usersDAO.readUsers(id);
        sessionData.setLogged(true);
        sessionData.setUserFbId(id);
        sessionData.setUserId(user.getId().intValue());


//        System.out.println(String.format("name = %s, email = %s", name, email));
        System.out.println(oAuthResp.getBody());
        resp.sendRedirect("/sionach-ux");
    }
}

