//import com.sionach.ux.accessibility.AccessibilityClip;
//import com.sionach.ux.filemanagment.ReadFiles;
//
//import javax.ejb.EJB;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by allic on 04/11/2016.
// */
//
//@WebServlet(urlPatterns = "/accessibility")
//public class AccessibilityServlet extends HttpServlet {
//
//    @EJB
//    AccessibilityClip accessibilityClip;
//    @EJB
//    ReadFiles htmlFile;
//
//    @Override
//    protected void doPost (HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        String htmlPath = req.getParameter("HTMLpath1");
//        htmlFile.setDefaultPatch(htmlPath);
//
//        String htmlInString = htmlFile.readFileToString(htmlPath);
//
//        accessibilityClip.Accessibility(htmlInString);
//
//        req.setAttribute("listAccessibility", accessibilityClip);
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/formAccessibility.jsp");
//        dispatcher.forward(req, resp);
//
//    }
//
//}
