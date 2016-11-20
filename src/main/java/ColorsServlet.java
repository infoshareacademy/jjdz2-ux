import com.sionach.ux.color.ClipColors;
import com.sionach.ux.color.CssListFromHtml;
import com.sionach.ux.filemanagment.ReadFiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Created by allic on 02/11/2016.
 */

@WebServlet(urlPatterns = "/colors")
public class ColorsServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(ColorsServlet.class);

    @EJB
    ClipColors clipColors;
    @EJB
    ReadFiles htmlFile;
    @EJB
    ReadFiles cssFile;
    @EJB
    CssListFromHtml cssFromHtml;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/formColors.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String choose = req.getParameter("choose");
        cssFile.setDefaultPatch("target/classes/" + choose + "/style.css");
        htmlFile.setDefaultPatch("target/classes/" + choose + "/");

        String htmlInString = htmlFile.readFileToString("index.html");

        Set<String> distinctHex = clipColors.ClipColorsFromData(htmlInString,cssFile);
        LOGGER.info("przekazujemy Color Servelt {}",clipColors );

        req.setAttribute("listOfColors", distinctHex);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/formColors.jsp");
        dispatcher.forward(req, resp);

    }

}