import com.sionach.ux.color.ClipColors;
import com.sionach.ux.color.CssListFromHtml;
import com.sionach.ux.filemanagment.ReadFiles;

import javax.ejb.EJB;
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

    @EJB
    ClipColors clipColors;
    @EJB
    ReadFiles htmlFile;
    @EJB
    ReadFiles cssFile;
    @EJB
    CssListFromHtml cssFromHtml;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String htmlPath = req.getParameter("HTMLpath");
        String cssPath = req.getParameter("CSSpath");

        htmlFile.setDefaultPatch(htmlPath);
        cssFile.setDefaultPatch(cssPath);

        String htmlInString = htmlFile.readFileToString(htmlPath);

        Set<String> distinctHex;
        distinctHex = clipColors.ClipColorsFromData(htmlInString,cssFile);

        req.setAttribute("listOfColors", distinctHex);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/fromClip.jsp");
        dispatcher.forward(req, resp);
    }

}