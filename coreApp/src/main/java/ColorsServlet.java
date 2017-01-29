import com.sionach.ux.color.ClipColors;
import com.sionach.ux.color.CssListFromHtml;
import com.sionach.ux.databaseEntities.ColorsDAO;
import com.sionach.ux.filemanagment.ReadFiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
    @EJB
    ColorsDAO colorsDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/formColors.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String domainUrl = req.getParameter("domainurl");


        try {
            URL url = new URL(domainUrl);
            URLConnection conn = url.openConnection();
            conn.connect();

            Set<String> distinctHex = clipColors.ClipColorsFromData(domainUrl);
            LOGGER.info("przekazujemy Color Servelt {}",clipColors );

            colorsDAO.save(distinctHex);
            colorsDAO.readColors();
            req.setAttribute("listOfColors", distinctHex);

            req.setAttribute("domainurl", domainUrl.replaceAll("http://", "").replaceAll("https://", ""));



        }catch (MalformedURLException e){
            //nieprawidlowy format
            String badForm = "Nieprawidłowy format adresu url Twojej witryny";
            req.setAttribute("badform", badForm);
        }catch (IOException e){
            //nie mozna nawiazac polaczenia
            String badConnect = "Niemożna nawiązać połączenia z Twoją witryną";
            req.setAttribute("badconnect", badConnect);
        }
        //przekazanie do formColors.jsp

        RequestDispatcher dispatcher = req.getRequestDispatcher("/colors.jsp");
        dispatcher.forward(req, resp);
    }

}