package org.projet.Servlet;

import org.projet.DBGestion.Etudiant;
import org.projet.DBGestion.EtudiantDAOImpl;
import org.projet.DBGestion.EtudiantService;
import org.projet.DBGestion.EtudiantServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GestEtu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //this.doProcess(request,response);

        System.out.println("coucou");
        EtudiantService etudiantService = new EtudiantServiceImpl();

        String state = request.getParameter("state");

        if (state != null && state.equals("suppr")) {
            String id = request.getParameter("id");
            System.out.println("suppr" + request.getParameter("id"));

           Etudiant etudiant = etudiantService.getEtudiantsById(id);

           etudiantService.supprEtudiant(etudiant);

        }
        else if (state != null && state.equals("modif")) {

            String prenom = request.getParameter("prenom");
            String nom = request.getParameter("nom");
            String id = request.getParameter("id");

            Etudiant etuAchanger, etudiantModif;

            etuAchanger = etudiantService.getEtudiantsById(id);

            etudiantModif = new Etudiant(
                    "3", nom, prenom,
                    "12/21/1994",
                    "none", "none", "none",
                    "none", "none", "none", "none"
            );

            etudiantService.modifEtudiant(etuAchanger,etudiantModif);

            System.out.println("modif"+request.getParameter("id"));
            this.doProcess(request, response);


        }

        else {
            System.out.println("creation");
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");

            System.out.println(nom + prenom);

            Etudiant etu = new Etudiant(
                    "3", nom, prenom,
                    "12/21/1994",
                    "none", "none", "none",
                    "none", "none", "none", "none"
            );

            etudiantService.addEtudiant(etu);
            this.doProcess(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request,response);
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response) {

        //Récupération des données de liste des étudiants
        EtudiantService etuService = new EtudiantServiceImpl();
        System.out.println("<<<<<<<On va chercher la liste>>>>>>>");
        List<Etudiant> listEtudiants = etuService.getAllEtudiants();
        System.out.println("<<<<<<<<on a la liste : >>>>>>>>>>>>> \n");
        System.out.println(listEtudiants);

        EtudiantDAOImpl.test();
        request.setAttribute("listEtudiants",listEtudiants);


        //Récupération et envoie de la page
        String pageName="/WEB-INF/GestEtu.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
