import com.sionach.ux.databaseEntities.FavKeywords;
import com.sionach.ux.databaseEntities.FavKeywordsDAO;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@WebServlet(urlPatterns = "/favkeywordsdomain")
public class KeywordsDomainFavServlet extends HttpServlet {

    @Inject
    FavKeywordsDAO favKeywordsDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int domainId = parseInt(req.getParameter("selectdomain"));
        String keywordToRemove = req.getParameter("keywordremove");
        String res = "";
        if(keywordToRemove!=null){
            System.out.println("domena: "+domainId);
            System.out.println("keyword: "+keywordToRemove);
             res = favKeywordsDAO.ramoveKeyword(keywordToRemove, domainId);
        }else if (domainId > 0){
             res = favKeywordsDAO.keywordsListByDomainId(domainId).stream()
                    .map(FavKeywords::getKeywords)
                    .collect(Collectors.joining(", "));
        }



        resp.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
        resp.setCharacterEncoding("UTF-8"); // You want world domination, huh?
        resp.getWriter().write(res);
    }
}
