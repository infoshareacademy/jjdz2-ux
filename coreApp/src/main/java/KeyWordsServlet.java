import com.sionach.ux.keyWords.KeyWords;
import org.jsoup.HttpStatusException;

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

@WebServlet(urlPatterns = "/keywords")
public class KeyWordsServlet extends HttpServlet {

    @EJB
    KeyWords keyWords;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String link = req.getParameter("domainurl");

        try {
            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            conn.connect();

            req.setAttribute("domainurl", link);
            req.setAttribute("keyWords", keyWords.keyWordsListLinks(keyWords.extractKeyWords(link)));
        } catch (HttpStatusException e) {
            e.printStackTrace();
            String refusedConnection = "Strona odmówiła komunikacji";
            req.setAttribute("refusedConnection", refusedConnection);
        } catch (MalformedURLException e) {
            //nieprawidlowy format
            String badForm = "Nieprawidłowy format adresu url Twojej witryny";
            req.setAttribute("badform", badForm);
            //strona odmówiła połączenia
        } catch (IOException e) {
            //nie mozna nawiazac polaczenia
            String badConnect = "Niemożna nawiązać połączenia z Twoją witryną";
            req.setAttribute("badconnect", badConnect);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/keywords.jsp");

        dispatcher.forward(req, resp);
    }
}
