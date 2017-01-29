package com.sionach.ux.facebook;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ablazejewska on 29.01.17.
 */

@WebFilter(urlPatterns = {"/colorReport"})
public class LevelFilter implements Filter{

    @Inject
    SessionData sessionData;

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        if (sessionData.getLevel() != "ADMIN" ) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            ((HttpServletResponse) servletResponse).sendRedirect(
                    "/sionach-ux");
            return;
        }

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
