<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 09.05.2018
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <title>Users</title>
</head>
<body>
<h1>All Users</h1>

<table class="table table-striped custab">
    <thead>
    <tr>
        <th>#ID</th>
        <th>Full Name</th>
        <th>Email</th>
        <th>Degree</th>
    </tr>
    </thead>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td><a href="${rootURL}/user/info/${user.id}">${user.fullName}</a></td>
            <td>${user.email}</td>
            <td>${user.degree}</td>
        </tr>
    </c:forEach>
</body>
</html>
