package org.projet.Servlet;

import org.projet.DBGestion.UserService;
import org.projet.DBGestion.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ConnectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        UserService userDB = new UserServiceImpl();
        System.out.print(name+"  "+password);
        if (name==null||password==null) {
            System.out.println("Informations incorrectes");
            session.setAttribute("tryConnect",true);
            session.setAttribute("messageErreur","La page que vous cherchez à atteindre n'est accessible qu'aux utilisateurs connectés.");
        }
        else {
            if (userDB.verifyUserIdentity(name,password)) {
                try {
                    session.setAttribute("role",userDB.getUserRole(name));

                session.setAttribute("connected",true);
                session.setAttribute("tryConnect",false);
                } catch (Exception e) {
                    e.printStackTrace();
                    session.setAttribute("tryConnect",true);
                    session.setAttribute("messageErreur","Erreur lors de la connection");
                }
            }
            else {
                session.setAttribute("tryConnect",true);
                session.setAttribute("messageErreur","Les identifiants que vous avez fournis sont incorrects");
            }
        }

        response.sendRedirect(request.getContextPath()+"/main");
    }
}

