<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 19.06.2018
  Time: 21:40
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
    <sec:authorize access="isAuthenticated()">
        You are already registered.
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <form:form action="/register" method="post" modelAttribute="userDtoReg">
            <form:errors path="*" cssClass="error"/><br>
            Full Name: <form:input path="fullName"/><br>
            Age: <form:select path="age">
            <form:options items="${nums}"/>
        </form:select><br>
            Email: <form:input path="email" type="email"/><br>
            Password: <form:input path="password"/><br>
            Password Confirm: <form:input path="passwordConfirm"/><br>
            Country: <form:select path="country">
            <form:options items="${countries}"/>
        </form:select><br>
            <button type="submit">Register</button>
        </form:form>
    </sec:authorize>
</body>
</html>
