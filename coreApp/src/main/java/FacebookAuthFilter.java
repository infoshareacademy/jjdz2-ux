import com.sionach.ux.facebook.SessionData;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by allic on 15/01/2017.
 */

@WebFilter(urlPatterns = {"/domainkeywords", "/accessibility", "/colors", "/keywords", "/routing", "/"})
public class FacebookAuthFilter implements Filter {

    @Inject
    SessionData sessionData;

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        if (!sessionData.isLogged()) {
            // jeżeli nie
            //   -> login.jsp
            //   -> referrerURL
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            ((HttpServletResponse) servletResponse).sendRedirect(
                    "/sionach-ux/facebooklogin");

            return;
        }
        // sprawdz czy zalogowany

        servletRequest.setAttribute("sessionData", sessionData);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
