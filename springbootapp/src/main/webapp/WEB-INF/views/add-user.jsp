<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 16.05.2018
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
    <form:form action="/add/user" method="post" modelAttribute="user">
        <form:errors path="*" cssClass="error"/><br>
        Email <form:input path="email" type="email"/><form:errors path="email" cssClass="error"/><br>
        Login <form:input path="login"/><form:errors path="login" cssClass="error"/><br>
        Password <form:input path="pass" type="password"/><form:errors path="pass" cssClass="error"/><br>
        Confirm <form:input path="passConfirm" type="password"/><form:errors path="passConfirm" cssClass="error"/><br>

        <button type="submit">Add user</button>
    </form:form>
</body>
</html>
