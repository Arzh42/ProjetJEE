package org.projet.Servlet;

import org.projet.DBGestion.UserService;
import org.projet.DBGestion.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class changeRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String question = request.getParameter("role");
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        if (role.equals("admin")) {
            UserService userDB = new UserServiceImpl();
            userDB.changeRole(name,role);
        }
    }
}
