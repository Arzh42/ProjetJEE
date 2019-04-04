package org.projet.Servlet;

import org.projet.DBGestion.*;

import javax.management.modelmbean.ModelMBeanInfoSupport;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.security.spec.ECField;
import java.util.List;

public class GAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) request.getParameter("name");
        String role = (String) request.getParameter("role");
        HttpSession session = request.getSession();
        String roleU = (String) session.getAttribute("role");
        if ("admin".equals(roleU)) {
            UserService userDB = new UserServiceImpl();

            try {
                userDB.changeRole(name,role);
                this.doProcess(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            response.sendRedirect(request.getContextPath()+"/main");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.doProcess(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        if ("admin".equals(role)) {
            UserService userDB = new UserServiceImpl();
            List<User> u = userDB.getUsers();
            request.setAttribute("users",u);

            //Récupération et envoie de la page
            String pageName="/WEB-INF/GestionAdministration.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
            try {
                rd.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        else {
            request.setAttribute("users",null);

            //Récupération et envoie de la page
            String pageName="/WEB-INF/GestionAdministration.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
            try {
                rd.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }


    }
}
