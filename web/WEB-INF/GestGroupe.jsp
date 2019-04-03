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
        for (Groupe g : listGroupes) {
            String nom = g.getNom();
            String dateCreation = g.getDateCreation();
    %>
    <li id="gr<%=nom%>">Groupe <%=nom%>,créé le  <%=dateCreation%></li>
    <%
        }
    %>
</ul>
<section>
    <div id="etu_data"></div>
    <div id="action">
        <button id="create_grp">Créer un nouveau groupe</button>
        <button id="modif_grp">Modifier un groupe</button>
        <button id="suppr_grp">Supprimer un groupe</button>
    </div>
</section>

</body>
</html>