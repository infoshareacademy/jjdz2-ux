import com.sionach.ux.color.ClipColors;
import com.sionach.ux.color.CssListFromHtml;
import com.sionach.ux.databaseEntities.Colors;
import com.sionach.ux.filemanagment.ReadFiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
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

    @PersistenceContext
    EntityManager entityManager;

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

//        //pobranie czasu utworzenia listy distinctHex
//        List<Long> domains = entityManager.createQuery("SELECT d.id FROM Domains d", Long.class).getResultList();
//        System.out.println(domains);

        //zapis do bazy danych wyszukanych kolorów
        for (String hex:distinctHex){
            Colors colors = new Colors();
            colors.setColors(hex);
            colors.setDomain_id(22364);
            colors.setTest_date("24.11.1991");
            //entityManager.getTransaction().begin();
            entityManager.persist(colors);
            //entityManager.getTransaction().commit();
            //entityManager.close();
        }

        List<String> colores = entityManager.createQuery("SELECT d.colors FROM Colors d", String.class).getResultList();
        System.out.println(colores);

        //przekazanie do formColors.jsp
        req.setAttribute("listOfColors", distinctHex);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/formColors.jsp");
        dispatcher.forward(req, resp);



    }

}