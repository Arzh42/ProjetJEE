<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="org.projet.DBGestion.Etudiant" %>
<%@ page import="java.util.List" %>
<%
    List<Etudiant> listEtudiants = (List<Etudiant>)request.getAttribute("listEtudiants");
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
<section id="groupeNavigation">
    <ul>
        <li class="groupeChoice" id="groupe1">Groupe 1</li>
    </ul>
    <button id="creerGroupe">Créer un nouveau groupe</button>
</section>
<section id="AffGroupe" class="formGroupe">
    <h2>Nom du groupe</h2>
    <h3>Nom du propriétaire</h3>
    <span class="groupe_creation_date">15/05>2018</span>
    <button id="supprGroupe">Supprimer le groupe</button>
    <div id="liste_etu">
        <input type="checkbox" id="etu_id" name="etu_id" />
        <label for="etu_id">Etudiant 1</label>
        <input type="checkbox" id="etu_id2" name="etu_id2"  />
        <label for="etu_id2">Etudiant 2</label>
        <button id="exclude">Exclude from the group</button>
    </div>
    <div id="liste_groupe">
        <input type="checkbox" id="groupe_id" name="groupe1" />
        <label for="etu_id">Etudiant 1</label>
        <input type="checkbox" id="groupe_id2" name="groupe2"  />
        <label for="etu_id2">Etudiant 2</label>
        <button id="exclude_groupe">Exclude from the group</button>

    </div>
    <button id="openAddStudent">Add Student</button>
    <div style="display:none" id="liste_etu_for_add">
        <input type="checkbox" id="add_etu_id" name="etu_id" />
        <label for="add_etu_id">Etudiant 1</label>
        <input type="checkbox" id="add_etu_id2" name="etu_id2"  />
        <label for="add_etu_id2">Etudiant 2</label>
        <button id="addEtu">Add the etu in the group</button>
    </div>
    <button id="openAddGroupe">Add Groupe</button>
    <div style="display:none; id="liste_groupe_for_add">
        <input type="checkbox" id="add_groupe_id" name="etu_id" />
        <label for="add_groupe_id">Etudiant 1</label>
        <input type="checkbox" id="add_groupe_id2" name="etu_id2"  />
        <label for="add_groupe_id2">Etudiant 2</label>
        <button id="addGroupe">Add the etu in the group</button>
    </div>
</section>
<section id="modifyGroupeForm" class="formGroupe">
    <form method="post" action="modifyGroupe">
        <h2><input type="text" name="group_name" value="Nom du groupe" /></h2>
        <h3>Nom du propriétaire</h3>
        <input class="groupe_creation_date" type="text" name="creation_date" value="15/05>2018">
        <button id="sendModifyGroupe">Modify</button>
    </form>

</section>

<section id="createGroupeForm" class="formGroupe">
    <form method="post" action="createGroupe">
        <input type="text" name="group_name" placeholder="Nom du groupe"/>
        <input class="groupe_creation_date" type="text" name="creation_date" placeholder="15/03/1997">
        <button id="sendCreateGroupe">Create</button>
    </form>
</section>
</body>
</html>