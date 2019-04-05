package org.projet.Ajax;

import org.projet.DBGestion.Etudiant;
import org.projet.DBGestion.EtudiantService;
import org.projet.DBGestion.EtudiantServiceImpl;
import org.projet.DBGestion.Groupe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Groupe_data extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EtudiantService etuService = new EtudiantServiceImpl();


        try {
            System.out.println("Accès à un groupe");
            String attrId = request.getParameter("id");
            String id = attrId.split("gr")[1];
            System.out.println(etuService.toString());
            Groupe gr = etuService.getGroupeByNom(id);
            System.out.println(gr.toString());
            request.setAttribute("Groupe",gr);
            String pageName="/WEB-INF/groupe_data.jsp";
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
