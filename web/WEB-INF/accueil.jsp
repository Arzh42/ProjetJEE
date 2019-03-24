<%@ page import="org.tutorial.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="org.tutorial.BookDAO" %><%--
  Created by IntelliJ IDEA.
  User: hugo
  Date: 15/02/19
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Book> listBooks = (List<Book>)request.getAttribute("listBooks");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Accueil</h1>
    <h3>Liste des livres : </h3>
    <table border="1">
        <tr>
            <th>Titre</th>
            <th>Auteur</th>
        </tr>
        <%
            for (Book book:listBooks) {
                String title = book.getTitle();
                String author = book.getAuthor();
        %>
        <tr>
            <td><%=title%></td>
            <td><%=author%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
