//import com.sionach.ux.filemanagment.ReadFiles;
//import com.sionach.ux.keyWords.KeyWordsClip;
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
//@WebServlet(urlPatterns = "/keywords")
//
//
//public class KeyWordsServlet extends HttpServlet{
//
//    @EJB
//    KeyWordsClip keyWordsClip;
//    @EJB
//    ReadFiles htmlFile;
//
//    @Override
//    protected void doPost (HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        String htmlPath = req.getParameter("HTMLpath2");
//        htmlFile.setDefaultPatch(htmlPath);
//
//        String htmlInString = htmlFile.readFileToString(htmlPath);
//
//        keyWordsClip.KeyWordsFromData(htmlInString);
//
//        req.setAttribute("listAccessibility", keyWordsClip.getKeyWords());
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/formKeyWords.jsp");
//        dispatcher.forward(req, resp);
//
//    }
//
//
//}
