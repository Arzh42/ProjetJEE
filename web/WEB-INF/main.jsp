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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <script type="text/javascript" src="./javascripts/jquery.js"> </script>

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
        <input type="text" placeholder="login" name="name"/>
        <input type="password" placeholder="password" name="password" id="password"/>
        <button id="send">Connexion</button>
      </form>
        <button id="forgetPassword">Mot de passe oublié ?</button>
        <form id="forgetPasswordForm" style="display: none;" method="post" action="forgetPassword">
            <input type="text" placeholder="login" id="name" name="name"/>
            <br>
            <span id="question"></span>
            <br>
            <input type="text" placeholder="reponse" name="reponse" />
            <label for="changePass">Nouveau mot de passe : </label>
            <input type="password" id="changePass" name="password"/>
            <button>Envoyer</button>
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
    <br>
  </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script>
        $('#forgetPassword').on('click',function() {
            $.post('getQuestion',{},function(result) {
                $('#question').html(result);
            });
            $('#forgetPasswordForm').css('display','');
        });
    </script>
  </body>
</html>
