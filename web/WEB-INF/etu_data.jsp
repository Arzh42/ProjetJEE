<%@ page import="org.projet.DBGestion.Etudiant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Etudiant etu = (Etudiant) request.getAttribute("Etudiant");
%>
<span class="etu_data_item" id="id"><%=etu.getId()%></span>
<span class="etu_data_item" id="prenom"><%=etu.getPrenom()%></span>
<span class="etu_data_item" id="nom"><%=etu.getNom()%></span>
<span class="etu_data_item" id="date_de_naissance"><%=etu.getDate_de_naissance()%></span>
<span class="etu_data_item" id="courrielPro"><%=etu.getCourrielPro()%></span>
<span class="etu_data_item" id="courrielPerso"><%=etu.getCourrielPerso()%></span>
<span class="etu_data_item" id="serieBac"><%=etu.getSerieBac()%></span>
<span class="etu_data_item" id="dateBac"><%=etu.getDateBac()%></span>
<span class="etu_data_item" id="mentionBac"><%=etu.getMentionBac()%></span>
<span class="etu_data_item" id="diplome"><%=etu.getDiplome()%></span>
<span class="etu_data_item" id="dateDiplome"><%=etu.getDateDiplome()%></span>
