<%--
  Created by IntelliJ IDEA.
  User: hugo
  Date: 18/02/19
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  boolean tryConnect = (boolean) request.getAttribute("tryConnect");
  boolean connected = (boolean) request.getAttribute("connected");
  String messageErreur = (String) request.getAttribute("messageErreur");
%>
<html>
  <head>
    <title>Gestionnaire</title>
  </head>
  <body>
    <header>
      <h1>Gestionnaire</h1>
    </header>
    <%
      if (tryConnect) {
        %>
    <p><%=messageErreur%></p>
    <%
      }
    if (connected) {
      %>
    <div>
      <span>Vous êtes connecté</span>
      <br>
      <a href="deco">Deconnect</a>
    </div>
    <br>
    <br>
    <%
    }
    else {
      %>
    <div style="display: inline-block;" class="logBox">
      <form method="post" action="connection">
        <h3 style="display: inline-block;">Connexion : </h3>
        <input type="text" placeholder="login" id="name" name="name"/>
        <input type="password" placeholder="password" name="password" id="password"/>
        <button id="send">Connexion</button>
      </form>
    </div>
    <%
    }
    %>
  <div id="conteneurLien">
    <a href="user/GestEtu">Gestion des étudiants</a>
    <br>
    <a href="user/GestGroupe">Gestion des groupes</a>
    <br>
    <a href="user/GestionCompte">Gestion des comptes utilisateurs</a>
  </div>

  </body>
</html>
