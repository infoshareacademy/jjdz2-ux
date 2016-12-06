import com.sionach.ux.form.QuestionForm;
import com.sionach.ux.form.QuestionsJsonReader;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {

    @EJB
    QuestionsJsonReader qJsonReader;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<QuestionForm> questions = qJsonReader.readJsonFile();

        req.setAttribute("questions", questions);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/form.jsp");
        dispatcher.forward(req, resp);
    }
}
