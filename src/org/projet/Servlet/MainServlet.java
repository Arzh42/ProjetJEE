package org.projet.Servlet;

import org.projet.DBGestion.WebServiceLink.URLToFile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request,response);
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response) {
            //Récupération et envoie de la page
            String pageName="/WEB-INF/main.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
            HttpSession session = request.getSession();
            if (session.getAttribute("connected")!=null) {
                request.setAttribute("connected",session.getAttribute("connected"));
            }
            else {
                request.setAttribute("connected",false);
            }
            if (session.getAttribute("tryConnect")!=null) {
                request.setAttribute("tryConnect",session.getAttribute("tryConnect"));
                request.setAttribute("messageErreur",session.getAttribute("messageErreur"));
            }
            else {
                request.setAttribute("tryConnect",false);
                request.setAttribute("messageErreur","Action Impossible");
            }
            try {
                rd.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }

    }
}
