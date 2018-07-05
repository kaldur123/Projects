<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 03.06.2018
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h2>Welcome to Register-Form</h2>
    <form:form action="/register" method="post" modelAttribute="userDto">
        Login <form:input path="login"/><br>
        Password <form:input path="password" type="password"/><br>
        Phone number <form:input path="phoneNumber"/><br>
        Birth Day <form:input path="date" type="date"/><br>
        City <form:input path="city"/><br>
        Street <form:input path="street"/><br>
        Role <form:select path="role">
            <form:options items="${roles}"/>
        </form:select>
        <button type="submit">Register</button>
    </form:form>
</body>
</html>
