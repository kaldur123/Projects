<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 19.06.2018
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Admin Page<br>
    Hello, ${adminProfile.fullName}<br>
    <a href="/admin/info">Info</a><br>
    <a href="/admin/edit">Edit</a><br>
    <a href="/admin/add-dino">Add dino</a><br>
    <a href="/admin/users">Show all users</a>
    <form:form action="/logout" method="post">
        <button type="submit">Logout</button>
    </form:form>
</body>
</html>
