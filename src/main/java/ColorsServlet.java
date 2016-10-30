import com.sionach.ux.color.ClipColors;
import com.sionach.ux.color.ConvertColorToHex;
import com.sionach.ux.filemanagment.ReadFiles;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by porszt on 30.10.16.
 */

@WebServlet(urlPatterns = "/colors")
public class ColorsServlet extends HttpServlet{


    @EJB
    ConvertColorToHex convertColorToHex;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String color = req.getParameter("color");
        String convertedColor = convertColorToHex.checkColorFormatAndConvert(color);


        req.setAttribute("colorHex", convertColorToHex.getColorHex());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");

        dispatcher.forward(req, resp);
    }
}
