import com.sionach.ux.keyWords.KeyWords;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/keywords")
public class KeyWordsServlet extends HttpServlet {

    @EJB
    KeyWords keyWords;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String link = req.getParameter("domainurl");

        req.setAttribute("keyWords", keyWords.keyWordsListLinks(keyWords.extractKeyWords(link)));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/keywords.jsp");

        dispatcher.forward(req, resp);
    }
}
