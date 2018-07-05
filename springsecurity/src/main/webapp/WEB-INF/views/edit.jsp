<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 04.06.2018
  Time: 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/client/edit" method="post" modelAttribute="client">
    Login <form:input path="login" name="login" value="${client.login}"/><br>
    Password <form:input path="password" name="password" type="password" value="${client.password}"/><br>
    Phone number <form:input path="phoneNumber" name="phoneNumber" value="${client.phoneNumber}"/><br>
    Birth Day <form:input path="date" type="date" name="date" value="${client.date}"/><br>
    City <form:input path="city" name="city" value="${client.city}"/><br>
    Street <form:input path="street" name="street" value="${client.street}"/><br>
    <button type="submit">Edit</button>
</form:form>
</body>
</html>
