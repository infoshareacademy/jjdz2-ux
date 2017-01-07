import com.sionach.ux.accessibility.AccessibilityRecommendations;
import com.sionach.ux.accessibility.DeprecatedTagsInHtml;
import com.sionach.ux.accessibility.LinksInHtml;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/accessibility")
public class AccessibilityServlet extends HttpServlet {

    @EJB
    DeprecatedTagsInHtml deprecatedTagsInHtml;
    @EJB
    AccessibilityRecommendations accessibilityRecommendations;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/accessibility.jsp");
        dispatcher.forward(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String domainUrl = req.getParameter("domainurl");

        accessibilityRecommendations.setDomainUrl(domainUrl);

        req.setAttribute("linksInHtml", accessibilityRecommendations.checkLinksInHtml());
        req.setAttribute("deprecatedTags", accessibilityRecommendations.checkDeprecatedTags());
        req.setAttribute("headRecommendations", accessibilityRecommendations.checkHeadParameters());
        req.setAttribute("headlinesHtml", accessibilityRecommendations.checkHeadlinesInBodyHtml());
        req.setAttribute("domainurl", domainUrl.replaceAll("http://","").replaceAll("https://",""));



        RequestDispatcher dispatcher = req.getRequestDispatcher("/accessibility.jsp");

        dispatcher.forward(req, resp);
    }
}
