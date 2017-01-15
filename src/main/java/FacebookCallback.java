import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringReader;

@WebServlet("/google-oauth-callback")
public class FacebookCallback extends HttpServlet {

    @Inject
    SessionData data;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = req.getParameter("error");
        if (error != null && "access_denied".equals(error.trim())) {
            HttpSession session = req.getSession();
            session.invalidate();
//            resp.sendRedirect("/login.jsp");
//            return;
        }

        final OAuth20Service oAuthService = data.getOAuthService();
        final String code = req.getParameter("code");// Access code with token

        OAuthRequest oAuthRequest = new OAuthRequest(Verb.GET, "https://www.googleapis.com/oauth2/v2/userinfo",
                oAuthService);

        oAuthService.signRequest(oAuthService.getAccessToken(code), oAuthRequest);
        Response oAuthResp = oAuthRequest.send();

        JsonReader reader = Json.createReader(new StringReader(oAuthResp.getBody()));
        JsonObject profile = reader.readObject();
        String name = profile.getString("name");
        String email = profile.getString("email");

        System.out.println(String.format("name = %s, email = %s", name, email));


//        resp.sendRedirect("/index.jsp");
    }
}