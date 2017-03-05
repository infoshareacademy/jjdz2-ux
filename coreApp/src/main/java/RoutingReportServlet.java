import com.sionach.ux.apiConsumer.RoutingApiConsumer;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/routingServlet")
public class RoutingReportServlet extends HttpServlet{

    @EJB
    RoutingApiConsumer api;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = api.getLinkForReport();

        req.setAttribute("routingReport", result);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/routingReport.jsp");
        dispatcher.forward(req, resp);
    }
}
