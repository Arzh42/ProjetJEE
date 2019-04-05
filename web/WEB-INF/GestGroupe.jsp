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
<ul id="listeGr">
    <%
        for (Groupe g : listGroupes) {
            String nom = g.getNom();
            String dateCreation = g.getDateCreation();
            String proprio = g.getNomProprietaire();
    %>
    <li id="<%=nom%>" class="groupeInListe" onclick="">Groupe <%=nom%>,créé le  <%=dateCreation%>, propriété de <%=proprio%></li>
    <%
        }
    %>
</ul>
    <div id="groupe_data" style="float: right;"></div>
    <div id="etu_data" style="float:right;"></div>
    <div id="action">
        <button id="create_grp">Créer un nouveau groupe</button>
        <button id="modif_grp">Modifier un groupe</button>
        <button id="suppr_grp">Supprimer un groupe</button>
        <button id="ajoutEtuGr">Ajouter un etudiant</button>
        <button id="supprEtuGr">Supprimer un etudiant</button>
    </div>

<div id="formCreation" class="formGroup" style="display: none">
    <form method="post" action="GestGroupe" >
        <br>
        Nom:<br>
        <input type="text" id="nom" name="nom" value="">
        <br>
        Nom du propriétaire:<br>
        <input type="text" id="nom_proprietaire" name="nom_proprietaire" value="">
        <br>
        Date de création:<br>
        <input type="text" id="date_creation" name="date_creation" value="">
        <input type="text" name="state" value="creation" style="display: none">

        <br><br>
        <input type="submit" id="submit" value="Submit">
    </form>
</div>

<div id="formModif" class="formGroup" style="display: none">
    <form method="post" action="GestGroupe">
        <br>
        Ancien Nom:<br>
        <input type="text" id="ancienNomModif" name="ancienNom" value="">
        <br>
        Nouveau Nom:<br>
        <input type="text" id="nouveauNomModif" name="nouveauNom" value="">
        <input type="text" style="display: none" name="state" value="modif">
        <br><br>
        <input type="submit" id="submitModif" value="Submit Modif">
    </form>
</div>
<div id="formSuppr" class="formGroup" style="display: none">
    <form method="post" action="GestGroupe">
        <br>
        Nom:<br>
        <input type="text" id="nomSuppr" name="nom" value="">
        <input type="text" name="state" value="suppr" style="display: none">
        <br><br>
        <input type="submit" id="submitSuppr" value="Submit Suppr">
    </form>
</div>
<div id="formAjoutEtu" class="formGroup" style="display: none">
    <form method="post" action="GestGroupe">
        <br>
        Nom du Groupe:<br>
        <input type="text" id="nomGrAjout" name="nomGr" value="">
        <br>
        Id de l'étudiant:<br>
        <input type="text" id="idEtu" name="idEtu" value="">
        <input type="text" name="state" value="AjoutEtu" style="display: none">
        <br><br>
        <input type="submit" id="submitAjoutEtu" value="Submit Ajout">
    </form>
</div>
<div id="formSupprEtu" class="formGroup" style="display: none">
    <form method="post" action="GestGroupe">
        <br>
        Nom du Groupe:<br>
        <input type="text" id="nomGrSuppr" name="nomGrSuppr" value="">
        <br>
        Id de l'étudiant:<br>
        <input type="text" id="idEtuSuppr" name="idEtuSuppr" value="">
        <input type="text" name="state" value="SupprEtu" style="display: none">
        <br><br>
        <input type="submit" id="submitSupprEtu" value="Submit Suppr">
    </form>
</div>
</body>
</html>