package org.projet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Etu_data extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EtudiantService etuService = new EtudiantServiceImpl();


        String attrId = request.getParameter("id");



        Etudiant etu = etuService.getEtudiantsById(attrId.split("etu")[1]);
        request.setAttribute("Etudiant",etu);

        String pageName="/etu_data.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
