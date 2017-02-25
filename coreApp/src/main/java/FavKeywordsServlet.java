
import com.sionach.ux.databaseEntities.DomainsDAO;
import com.sionach.ux.databaseEntities.DomainsKeywordsDAO;
import com.sionach.ux.facebook.SessionData;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;



@WebServlet(urlPatterns = "/favkeywords")
public class FavKeywordsServlet extends HttpServlet{

    @EJB
    DomainsKeywordsDAO domainsKeywordsDAO;

    @EJB
    DomainsDAO domainsDAO;

    @Inject
    SessionData sessionData;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int userid = parseInt(req.getParameter("userid"));
        String keyword = req.getParameter("keyword");
        String url = req.getParameter("url");
        String token = req.getParameter("token");
        String tokenToCompare = sessionData.getToken();
        if(!token.equals(tokenToCompare)){

            req.getSession().invalidate();
            resp.sendRedirect("http://disney.com");
        }

        int domainId = domainsDAO.domainIdByUrlAndUserId(url, userid).intValue();


        String res = domainsKeywordsDAO.saveKeywordOrDelete(keyword, domainId);

        resp.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
        resp.setCharacterEncoding("UTF-8"); // You want world domination, huh?
        resp.getWriter().write(res);
    }



}
