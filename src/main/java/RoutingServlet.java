import com.sionach.ux.filemanagment.ReadFiles;
import com.sionach.ux.routing.LinkManagement;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by allic on 04/11/2016.
 */

@WebServlet(urlPatterns = "/routing")
public class RoutingServlet {

    @EJB
    ReadFiles htmlFile;
    @EJB
    LinkManagement linkMenagement;

    protected void doPost (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String htmlPath = req.getParameter("HTMLpath1");
        htmlFile.setDefaultPatch(htmlPath);

        String htmlInString = htmlFile.readFileToString(htmlPath);

        linkMenagement = new LinkManagement(htmlInString, htmlPath);
        linkMenagement.parseLinksFromHtml();

        req.setAttribute("listAccessibility", linkMenagement.getLinks());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/formAccessibility.jsp");
        dispatcher.forward(req, resp);

    }

}
