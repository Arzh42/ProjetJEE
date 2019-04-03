<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="org.projet.DBGestion.Etudiant" %>
<%@ page import="java.util.List" %>
<%
  List<Etudiant> listEtudiants = (List<Etudiant>)request.getAttribute("listEtudiants");
%>
<html>
<head>
  <title>Liste Etudiant</title>
  <link rel="stylesheet" href="../stylesheets/GestEtu.css" type="text/css"/>
  <script type="text/javascript" src="../javascripts/jquery.js"> </script>
  <script type="text/javascript" src="../javascripts/GestEtu.js"></script>
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
        String id = etu.getId();
        String nom = etu.getNom();
        String prenom = etu.getPrenom();
    %>
      <li id="<%=id%>" onclick=""><%=nom%> <%=prenom%></li>
    <%
      }
    %>
  </ul>

    <div id="etu_data"></div>
    <div id="action">
      <button id="create_etu">Créer un nouvel étudiant</button>
      <button id="modif_etu">Modifier l'étudiant</button>
      <button id="suppr_etu">Supprimer l'étudiant</button>

      <div id="formCreation" style="display: none">
        <form method="post" action="GestEtu" >
          <br>
          Nom:<br>
          <input type="text" id="nom" name="nom" value="">
          <br>
          Prenom:<br>
          <input type="text" id="prenom" name="prenom" value="">

          <br><br>
          <input type="submit" id="submit" value="Submit">
        </form>
      </div>

      <div id="formModif" style="display: none">
        <form method="post" action="GestEtu">
          <br>
          Nom:<br>
          <input type="text" id="nomModif" name="nom" value="">
          <br>
          Prenom:<br>
          <input type="text" id="prenomModif" name="prenom" value="">
          <input type="text" style="display: none" name="state" value="modif">
          <input type="text" style="display: none" id="idcache" name="id" value="">
          <br><br>
          <input type="submit" id="submitModif" value="Submit Modif">
        </form>
      </div>
    </div>


</body>
</html>