<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 04.06.2018
  Time: 7:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/client/editpet/${pet.id}" method="post" modelAttribute="pet">
    Type <form:input path="type" name="type" value="${pet.type}"/><br>
    Age <form:input path="age" name="age" value="${pet.age}"/><br>
    Name <form:input path="name" name="name" value="${pet.name}"/><br>
    Color <form:input path="color" name="color" value="${pet.color}"/><br>
    Weight <form:input path="weight" name="weight" value="${pet.weight}"/><br>
    <button type="submit">Edit</button>
</form:form>
<a href="/client/editpet/image/${pet.id}">Edit pet image</a><br>
<a href="/client/visit/${pet.id}">Sign up for a doctor</a><br>
<form:form action="/client/deletepet" method="post" modelAttribute="pet">
    <button type="submit">Delete pet</button>
</form:form>
</body>
</html>
