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
    <span>Vous étes connecté</span>
    <a href="deco">Deconnect</a>
    <%
    }
    else {
      %>
    <div style="display: inline-block;" class="logBox">
      <form method="post" action="connection">
        <h3 style="display: inline-block;">Connection : </h3>
        <input type="text" placeholder="login" id="name" name="name"/>
        <input type="password" placeholder="password" name="password" id="password"/>
        <button id="send">Connection</button>
      </form>
    </div>
    <%
    }
    %>
  <a href="user/GestEtu">Gestion des étudiants</a>
  <a href="user/GestGroupe">Gestion des groupes</a>
    <a href="user/GestionCompte">Gestion des comptes utilisateurs</a>
  </body>
</html>
