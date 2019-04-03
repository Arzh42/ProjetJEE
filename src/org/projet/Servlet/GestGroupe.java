package org.projet.Servlet;

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
        this.doProcess(request,response);
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
