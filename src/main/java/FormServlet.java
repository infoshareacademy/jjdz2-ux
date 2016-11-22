import com.sionach.ux.form.PageValidationForm;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {

    @EJB
    PageValidationForm pageValidationForm;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();

        Map<String, String> answersMap;

        answersMap = pageValidationForm.generateAnswers(parameterMap);


        req.setAttribute("answers", answersMap);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/form.jsp");
        System.out.println("wysyłam");
        dispatcher.forward(req, resp);
    }
}
