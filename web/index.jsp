<%--
  Created by IntelliJ IDEA.
  User: hugo
  Date: 18/02/19
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <header>
      <h1>Gestionnaire</h1>
    </header>
    <div style="display: inline-block;" class="logBox">
      <form method="post" action="login">
        <h3 style="display: inline-block;">Connection : </h3>
        <input type="text" placeholder="login" id="login" name="login"/>
        <input type="password" placeholder="password" name="password" id="password"/>
        <button id="send">Connection</button>
      </form>
    </div>
  </body>
</html>
