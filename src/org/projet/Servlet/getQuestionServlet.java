package org.projet.Servlet;

import org.projet.DBGestion.UserService;
import org.projet.DBGestion.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class getQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        UserService userDB = new UserServiceImpl();
        String question = userDB.getQuestion(name);
        System.out.println(question);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream sout = response.getOutputStream();

        sout.print(question);
    }
}
