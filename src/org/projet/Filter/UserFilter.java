package org.projet.Filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession();


        if (session.getAttribute("connected")!=null && (boolean) session.getAttribute("connected")) {
            filterChain.doFilter(request,response);
        }
        else {
            session.setAttribute("tryConnect",true);
            session.setAttribute("messageErreur","La page que vous recherchez n'est accessible qu'aux utilisateurs concernés");
            response.sendRedirect(request.getContextPath()+"/main");
        }
    }

    @Override
    public void destroy() {

    }
}
