package org.projet.Servlet;

import org.projet.DBGestion.UserService;
import org.projet.DBGestion.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class changePassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String password3 = request.getParameter("password3");
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        UserService userDB = new UserServiceImpl();
        if (password2.equals(password3)) {
            if (userDB.verifyUserIdentity(name,password1)) {
                userDB.changePassword(name,password2);
            }
            else {
                session.setAttribute("messageErreur","Mot de passe invalide");
            }
        }
        else {
            session.setAttribute("messageErreur","Les mots de passe ne sont pas les mêmes");
        }

        response.sendRedirect(request.getContextPath()+"/user/GestionCompte");
    }
}
