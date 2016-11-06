import com.sionach.ux.filemanagment.ReadFiles;
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
    @EJB
    ReadFiles readFiles;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String folder = req.getParameter("folder");
        readFiles.setDefaultPatch("target/classes/" + folder + "/");
        String htmlCode = readFiles.readFileToString("index.html");

        req.setAttribute("keyWords", keyWords.extractKeyWords(htmlCode));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/keywords.jsp");

        dispatcher.forward(req, resp);
    }

}
