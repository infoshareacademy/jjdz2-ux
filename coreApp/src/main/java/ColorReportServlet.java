import com.sionach.ux.reports.ColorReport;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/colorReport")
public class ColorReportServlet extends HttpServlet {

    @EJB
    ColorReport colorReport;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("colors", colorReport.getColorsWithCounter());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/colorReport.jsp");
        dispatcher.forward(req, resp);
    }
}
