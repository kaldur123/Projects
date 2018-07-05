<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 06.05.2018
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <link rel="stylesheet" href="${rootURL}/resources/css/bootstrap.min.css">
    <title>Home Page</title>
</head>
<body>
    <container class="text-center">
        <h2>Home Page</h2>
        <p><a href="${rootURL}/animal/add" class="btn btn-default">Add animal</a></p>
        <p><a href="${rootURL}/animal/list" class="btn btn-danger">List of animals</a></p>
        <p><a href="${rootURL}/animal/add-spring" class="btn btn-success">Add(spring)</a></p>
        <p><a href="${rootURL}/user/add" class="btn btn-primary">Add user</a></p>
        <p><a href="${rootURL}/user/users" class="btn btn-primary">Users</a></p>
    </container>
</body>
</html>
