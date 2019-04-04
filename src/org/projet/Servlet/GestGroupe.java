package org.projet.Servlet;

import org.projet.DBGestion.Etudiant;
import org.projet.DBGestion.Groupe;
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

@WebServlet(name = "Servlet")
public class GestGroupe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EtudiantService etudiantService = new EtudiantServiceImpl();

        String state = request.getParameter("state");

        if (state != null && state.equals("suppr")) {
            String nom = request.getParameter("nom");
            System.out.println("suppr" + request.getParameter("nom"));

            Groupe g = etudiantService.getGroupeByNom(nom);
            System.out.println("coucouuuuuuuuuuuuuu" + g);
            etudiantService.supprGroupe(g);
            this.doProcess(request, response);

        }
        else if (state != null && state.equals("modif")) {

            String ancienNom = request.getParameter("ancienNom");
            String nouveauNom = request.getParameter("nouveauNom");

            Groupe gAchanger, gModif;

            gAchanger = etudiantService.getGroupeByNom(ancienNom);

            gModif = new Groupe(
                    nouveauNom, gAchanger.getNomProprietaire(), gAchanger.getDateCreation()
            );

            etudiantService.modifGroupe(gAchanger,gModif);

            System.out.println("modif"+request.getParameter("nom"));
            this.doProcess(request, response);


        }
        else if (state != null & state.equals("AjoutEtu")){
            String nomGr = request.getParameter("nomGr");
            String id = request.getParameter("idEtu");

            Groupe g = etudiantService.getGroupeByNom(nomGr);
            Etudiant etu = etudiantService.getEtudiantsById(id);
            etudiantService.ajoutEtuGroupe(g, etu);

            this.doProcess(request, response);
        }

        else {
            System.out.println("creation");
            String nom = request.getParameter("nom");
            String nomProprietaire = request.getParameter("nom_proprietaire");
            String dateCreation = request.getParameter("date_creation");


            Groupe g = new Groupe(
                    nom, nomProprietaire, dateCreation
            );

            etudiantService.addGroupe(g);
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
        List<Groupe> listGroupes = etuService.getAllGroupes();
        System.out.println("<<<<<<<<on a la liste : >>>>>>>>>>>>> \n");
        System.out.println(listGroupes);
        request.setAttribute("listGroupes",listGroupes);

        //Récupération et envoie de la page
        String pageName="/WEB-INF/GestGroupe.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
