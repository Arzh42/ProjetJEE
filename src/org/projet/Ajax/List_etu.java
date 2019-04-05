package org.projet.Ajax;

import org.projet.DBGestion.Etudiant;
import org.projet.DBGestion.EtudiantService;
import org.projet.DBGestion.EtudiantServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class List_etu extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EtudiantService etuService = new EtudiantServiceImpl();
        List<Etudiant> l = new ArrayList<>();

        try {
            String groupe = request.getParameter("id");
            if (groupe==null) {
                l = etuService.getAllEtudiants();
            }
            else {
                l = etuService.getAllEtudiantsInGroupe(groupe);
            }
            request.setAttribute("Etudiants",l);

            String pageName="/WEB-INF/list_etu.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
            try {
                rd.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        catch(IndexOutOfBoundsException e) {
            response.setContentType("text/html");
            response.setCharacterEncoding( "UTF-8" );
            PrintWriter out = response.getWriter();
            out.println("Ressource Id not attributed");
        }
        catch(Exception e) {
            response.setContentType("text/html");
            response.setCharacterEncoding( "UTF-8" );
            PrintWriter out = response.getWriter();
            out.println("Ressource not available");
        }


    }
}
