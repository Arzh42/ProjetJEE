<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="org.projet.Etudiant" %>
<%@ page import="java.util.List" %>
<%
  List<Etudiant> listEtudiants = (List<Etudiant>)request.getAttribute("listEtudiants");
%>
<html>
<head>
  <title>Liste Etudiant</title>
  <link rel="stylesheet" href="stylesheets/GestEtu.css" type="text/css"/>
  <script type="text/javascript" src="javascripts/jquery.js"> </script>
  <script type="text/javascript" src="javascripts/GestEtu.js"></script>
</head>
<body>
  <header>
    <h1>Gestionnaire</h1>
    <nav>
      <a href="GestEtu">Gestion Etudiant</a>
      <a href="GestGroupe">Gestion Groupe</a>
    </nav>
  </header>
  <ul id="listeEtu">
    <%
      for (Etudiant etu : listEtudiants) {
        int id = etu.getId();
        String nom = etu.getNom();
        String prenom = etu.getPrenom();
    %>
      <li id="etu<%=id%>"><%=nom%> <%=prenom%></li>
    <%
      }
    %>
  </ul>
  <section>
    <div id="etu_data"></div>
    <div id="action">
      <button id="create_etu">Créer un nouvel étudiant</button>
      <button id="modif_etu">Modifier l'étudiant</button>
      <button id="suppr_etu">Supprimer l'étudiant</button>
    </div>
  </section>

</body>
</html>