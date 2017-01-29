import com.sionach.ux.accessibility.AccessibilityRecommendations;
import com.sionach.ux.accessibility.DeprecatedTagsInHtml;
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
        try {
            URL url = new URL(domainUrl);
            URLConnection conn = url.openConnection();
            conn.connect();

            accessibilityRecommendations.setDomainUrl(domainUrl);

            req.setAttribute("linksInHtml", accessibilityRecommendations.checkLinksInHtml());
            req.setAttribute("deprecatedTags", accessibilityRecommendations.checkDeprecatedTags());
            req.setAttribute("headRecommendations", accessibilityRecommendations.checkHeadParameters());
            req.setAttribute("headlinesHtml", accessibilityRecommendations.checkHeadlinesInBodyHtml());
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

        RequestDispatcher dispatcher = req.getRequestDispatcher("/accessibility.jsp");

        dispatcher.forward(req, resp);
    }
}
