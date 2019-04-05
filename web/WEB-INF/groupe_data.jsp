<%@ page import="org.projet.DBGestion.Groupe" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Groupe gr = (Groupe) request.getAttribute("Groupe");
%>
<span class="gr_data_item" id="nom"><%=gr.getNom()%></span>
<span class="gr_data_item" id="dateCreation"><%=gr.getDateCreation()%></span>
<span class="gr_data_item" id="proprio"><%=gr.getNomProprietaire()%></span>

