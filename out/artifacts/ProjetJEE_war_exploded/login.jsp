<%--
  Created by IntelliJ IDEA.
  User: Hugo
  Date: 24/03/2019
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestion de sécurité</title>
</head>
<body>
    <form name="formLogin" action="j_security_check" method="post">
        <table>
            <tr>
                <td>Login : </td>
                <td><input type="text" name="j_username" value="" /></td>
            </tr>
            <tr>
                <td>Mot de passe : </td>
                <td><input type="password" name="j_password" value=""/></td>
            </tr>
        </table>
        <p align="center"><input type="submit" value="Connexion"/></p>
    </form>
</body>
</html>
