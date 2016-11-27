import com.sionach.ux.accessibility.DeprecatedTagsInHtml;
import com.sionach.ux.accessibility.LinksInHtml;
import com.sionach.ux.accessibility.SettingsInHeadElement;
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


@WebServlet(urlPatterns = "/accessibility")
public class AccessibilityServlet extends HttpServlet {

    @EJB
    LinksInHtml linksInHtml;
    @EJB
    DeprecatedTagsInHtml deprecatedTagsInHtml;
    @EJB
    SettingsInHeadElement settingsInHeadElement;


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String fileName = req.getParameter("filename");
//        String htmlCode = readFiles.readFileToString(fileName);
//        Long noLinks = linksInHtml.noOfLinksInHtml(htmlCode);
//        List<String> deprecatedList = deprecatedTagsInHtml.deprecatedHtmlTagsList(fileName);
//        String deprecatedTagsString;
//        if(deprecatedList.size()>0){
//            deprecatedTagsString = deprecatedList.toString();
//
//        }else{
//            deprecatedTagsString = "Strona nie posiada zdeprecjonowanych elementów";
//        }
//
//        req.setAttribute("linksInHtml", noLinks);
//        req.setAttribute("deprecatedTags", deprecatedTagsString);
//        //req.setAttribute("htmlcode", htmlCode);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/accessibility.jsp");
//
//        dispatcher.forward(req, resp);
//    }
//
//    @Override

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String domainUrl = req.getParameter("domainurl");
        Long noLinks = linksInHtml.noOfLinksInHtml(domainUrl);
        List<String> deprecatedList = deprecatedTagsInHtml.deprecatedHtmlTagsList(domainUrl);
        String deprecatedTagsString;
        settingsInHeadElement.setDomainUrl(domainUrl);
        int descriptionOccurance = settingsInHeadElement.checkNoDescriptionOccurance();
        int descriptionLength = settingsInHeadElement.checkDescriptionLength();
        int metaKeywordsOccurance = settingsInHeadElement.checkMetaKeywordsOccurance();
        int titleOccurance = settingsInHeadElement.checkNoTitleOccurance();
        int titleLength = settingsInHeadElement.checkTitleLength();
        int relCanonicalOccurance = settingsInHeadElement.checkNoRelCanonicalOccurance();
        boolean isRelCanonical = settingsInHeadElement.checkRelCanonical();
        boolean htmlLang = settingsInHeadElement.checkHtmlLang();



        if(deprecatedList.size()>0){
            deprecatedTagsString = deprecatedList.toString();

        }else{
            deprecatedTagsString = "Strona nie posiada zdeprecjonowanych elementów";
        }

        req.setAttribute("linksInHtml", noLinks);
        req.setAttribute("deprecatedTags", deprecatedTagsString);
        req.setAttribute("descriptionOccurance", descriptionOccurance);
        req.setAttribute("descriptionLength", descriptionLength);
        req.setAttribute("metaKeywordsOccurance", metaKeywordsOccurance);
        req.setAttribute("titleOccurance", titleOccurance);
        req.setAttribute("titleLength", titleLength);
        req.setAttribute("relCanonicalOccurance", relCanonicalOccurance);
        req.setAttribute("isRelCanonical", isRelCanonical);
        req.setAttribute("htmlLnag", htmlLang);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/accessibility.jsp");

        dispatcher.forward(req, resp);
    }
}
