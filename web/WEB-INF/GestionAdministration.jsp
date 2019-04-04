<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="org.projet.DBGestion.User" %><%--
  Created by IntelliJ IDEA.
  User: Hugo
  Date: 25/03/2019
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<User> list = (List<User>) request.getAttribute("users");

%>
<html>
<head>
    <title>Administration Compte Utilisateur</title>
</head>
<body>
    <h1>Administration du compte</h1>
        <h2>Changez mot de passe</h2>
    <form method="post" action="changePassword">
        <label for="password1">Votre ancien mot de passe : </label>
        <input type="password" name="password1" id="password1"/>
        <label for="password2">Nouveau mot de passe : </label>
        <input type="password" name="password2" id="password2"/>
        <label type="password3">Comfirmer le nouveau mot de passe : </label>
        <input type="password" name="password3" id="password3"/>
        <button>Changer le mot de passe</button>
    </form>
    <form method="post" action="changeQuestion">
        <label for="question">Question : </label>
        <input type="text" name="question" id="question"/>
        <label for="reponse">Réponse : </label>
        <input type="text" name="reponse" id="reponse"/>
        <button>Modifier</button>
    </form>

    <%
        if (list!=null) {
        for (int i=0;i<list.size();i++) {
    %>
    <ul>
        <li><%=list.get(i).getName()%> : <%=list.get(i).getRole()%> <form method="post" action="./GestionCompte"><input type="hidden" name="name" value="<%=list.get(i).getName()%>"/><input type="text" name="role" placeholder="Nouveau role"/><input type="submit"/></form></li>
    </ul>
<%
    }
    }
%>


</body>
</html>
