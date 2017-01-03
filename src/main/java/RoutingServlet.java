import com.sionach.ux.routing.LinkManagement;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/routing")
public class RoutingServlet extends HttpServlet{

    @EJB
    LinkManagement linkManagement;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String link = req.getParameter("domainurl");

        List<String> innerLinks = linkManagement.getInnerLinks(linkManagement.parseLinksFromHtml(linkManagement.getPageAsDocument(link)), link);
        List<String> outerLinks = linkManagement.getOuterLinks(linkManagement.parseLinksFromHtml(linkManagement.getPageAsDocument(link)), link);

        req.setAttribute("innerLinks", innerLinks);
        req.setAttribute("outerLinks", outerLinks);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/routing.jsp");
        dispatcher.forward(req, resp);
    }
}