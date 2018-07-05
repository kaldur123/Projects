<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 26.06.2018
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
    <style>
    table, td{
    border: 2px solid black;
    }
    </style>
</head>
<body>
<table>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td><a href="/articles/${article.id}">${article.title}</a></td>
            <td>${article.dino.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
