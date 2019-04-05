<%@ page import="org.projet.DBGestion.Etudiant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%
    List<Etudiant> listEtudiants = (List<Etudiant>)request.getAttribute("Etudiants");
%>
<ul id="listeEtu">
    <%
        for (Etudiant etu : listEtudiants) {
            String id = etu.getId();
            String nom = etu.getNom();
            String prenom = etu.getPrenom();
    %>
    <li class="etudiantInListe" id="<%=id%>" onclick=""><%=nom%> <%=prenom%></li>
    <%
        }
    %>
</ul>