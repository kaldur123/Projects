<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 16.05.2018
  Time: 16:18
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
<form:form action="/add/student-dto" method="post" modelAttribute="studentModel">
    <form:errors path="*" cssClass="error"/>
    First Name<form:input path="firstName"/><br>
    Last Name<form:input path="lastName"/><br>
    Age<form:input path="age" type="number"/><br>
    Password<form:password path="password"/><br>
    Password Confirm<form:password path="passwordConfirm"/><br>
    <button type="submit">Add student</button>
</form:form>
</body>
</html>
