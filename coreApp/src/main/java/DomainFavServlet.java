import com.sionach.ux.databaseEntities.FavDomainsDAO;
import com.sionach.ux.databaseEntities.FavKeywordsDAO;
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

@WebServlet(urlPatterns = "/domainkeywords")
public class DomainFavServlet extends HttpServlet{

    @EJB
    FavDomainsDAO favDomainsDAO;

    @EJB
    FavKeywordsDAO favKeywordsDAO;

    @Inject
    SessionData sessionData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = sessionData.getUserId();
        req.setAttribute("domainsList", favDomainsDAO.favDomainsByUserId(userId));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/favkeywords.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String domainUrl = req.getParameter("favdomain");
        String keywords = req.getParameter("favkeywords");

        String token = req.getParameter("token");
        String tokenToCompare = sessionData.getToken();
        if(!token.equals(tokenToCompare)){

            req.getSession().invalidate();
            resp.sendRedirect("http://disney.com");
        }else{
            int userId = sessionData.getUserId();
            int domainId = favDomainsDAO.favDomainInByUserIdAndUrl(userId, domainUrl);
            System.out.println("domena: "+domainId);
            favKeywordsDAO.saveFavKeywordsList(keywords, domainId);
            req.setAttribute("domainsList", favDomainsDAO.favDomainsByUserId(userId));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/favkeywords.jsp");
            dispatcher.forward(req, resp);
        }





    }
}
