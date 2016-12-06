import com.sionach.ux.form.MatchAnswers;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/formAnswers")
public class FormAnswersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        MatchAnswers matchAnswers = new MatchAnswers();
        List<String> answers = matchAnswers.getAnswers(parameterMap);

        req.setAttribute("answers", answers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/formAnswers.jsp");
        dispatcher.forward(req, resp);
    }
}
