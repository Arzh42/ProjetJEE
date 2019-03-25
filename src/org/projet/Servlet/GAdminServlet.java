package org.projet.Servlet;

import org.projet.DBGestion.Etudiant;
import org.projet.DBGestion.EtudiantService;
import org.projet.DBGestion.EtudiantServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.spec.ECField;
import java.util.List;

public class GAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            this.doProcess(request,response);
        } catch (Exception e) {
            e.printStackTrace();
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
        if (role!=null) {
            request.setAttribute("role",role);
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
            throw new Exception("Accès impossible normalement role non défini");
        }

    }
}
