<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 14.05.2018
  Time: 16:06
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
    <form:form action="/add/student" method="post" modelAttribute="studentModel">
        <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/> <br>
        <form:input path="lastName"/><form:errors path="lastName" cssClass="error"/><br>
        <form:input path="age" type="number"/><form:errors path="age" cssClass="error"/><br>
        <form:select path="country">
            <form:options items="${countries}" itemLabel="name"/>
        </form:select><form:errors path="country" cssClass="error"/>
        <button type="submit">Add student</button>
    </form:form>
</body>
</html>
