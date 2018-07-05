<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 26.06.2018
  Time: 23:07
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
<form:form action="/admin/edit" method="post" modelAttribute="user">
    <form:errors path="*" cssClass="error"/>
    Full Name: <form:input path="fullName"/><br>
    Age: <form:select path="age">
    <c:forEach items="${nums}" var="num">
        <form:option value="${num}">${num}</form:option>
    </c:forEach>
</form:select><form:errors path="age" cssClass="error"/><br>
    Country: <form:select path="country">
    <form:options items="${countries}"/>
</form:select><br>
    <button type="submit">Edit</button>
</form:form>
</body>
</html>
