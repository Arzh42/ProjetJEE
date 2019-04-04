<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="org.projet.DBGestion.Groupe" %>
<%@ page import="java.util.List" %>
<%
    List<Groupe> listGroupes = (List<Groupe>)request.getAttribute("listGroupes");
%>
<html>
<head>
    <title>Liste Groupe</title>
    <link rel="stylesheet" href="../stylesheets/GestGroupe.css" type="text/css"/>
    <script type="text/javascript" src="../javascripts/jquery.js"> </script>
    <script type="text/javascript" src="../javascripts/GestGroupe.js"></script>
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
        for (Groupe g : listGroupes) {
            String nom = g.getNom();
            String dateCreation = g.getDateCreation();
    %>
    <li id="gr<%=nom%>">Groupe <%=nom%>,créé le  <%=dateCreation%></li>
    <%
        }
    %>
</ul>
    <div id="action">
        <button id="create_grp">Créer un nouveau groupe</button>
        <button id="modif_grp">Modifier un groupe</button>
        <button id="suppr_grp">Supprimer un groupe</button>
    </div>

<div id="formCreation" class="formGroup" style="display: none">
    <form method="post" action="GestGroupe" >
        <br>
        Nom:<br>
        <input type="text" id="nom" name="nom" value="">
        <br>
        Nom du propriétaire:<br>
        <input type="text" id="nom_proprietaire" name="nom_proprietaire" value="">

        Date de création:<br>
        <input type="text" id="date_creation" name="date_creation" value="">

        <br><br>
        <input type="submit" id="submit" value="Submit">
    </form>
</div>

<div id="formModif" class="formGroup" style="display: none">
    <form method="post" action="GestGroupe">
        <br>
        Nom:<br>
        <input type="text" id="nomModif" name="nom" value="">
        <br>
        Nom du propriétaire:<br>
        <input type="text" id="nom_proprietaireModif" name="nom_proprietaire" value="">
        <br>
        Date de création:<br>
        <input type="text" id="date_creationModif" name="date_creation" value="">
        <br><br>
        <input type="submit" id="submitModif" value="Submit Modif">
    </form>
</div>

</body>
</html>