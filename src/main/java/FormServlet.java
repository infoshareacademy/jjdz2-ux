import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();

        System.out.println("\n##Jestem tutaj##\n");
        System.out.println(parameterMap);
        req.setAttribute("answers", parameterMap);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/form.jsp");
        System.out.println("wysyłam");
        dispatcher.forward(req, resp);
    }
}
