package org.projet.Servlet;

import org.projet.DBGestion.UserService;
import org.projet.DBGestion.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class changeQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String question = request.getParameter("question");
        String reponse = request.getParameter("reponse");
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        UserService userDB = new UserServiceImpl();

        userDB.changeQuestion(name,question,reponse);
        response.sendRedirect(request.getContextPath()+"/user/GestionCompte");
    }
}
