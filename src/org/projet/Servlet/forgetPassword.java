package org.projet.Servlet;

import org.projet.DBGestion.UserService;
import org.projet.DBGestion.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class forgetPassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reponse = request.getParameter("reponse");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserService userDB = new UserServiceImpl();
        System.out.println(reponse+" name "+name+" password "+password);
        if (userDB.verifyReponse(name,reponse)) {
            userDB.changePassword(name,password);
        }
        response.sendRedirect(request.getContextPath()+"/main");
    }
}
