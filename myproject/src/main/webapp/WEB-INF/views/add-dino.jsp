<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 20.06.2018
  Time: 16:15
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
    Add dino
    <form:form action="/admin/add-dino" method="post" modelAttribute="dinoDto">
        <form:errors path="*" cssClass="error"/>
        Name: <form:input path="name"/><br>
        Kind: <form:input path="kind"/><br>
        <button type="submit">Add</button>
    </form:form>
</body>
</html>
