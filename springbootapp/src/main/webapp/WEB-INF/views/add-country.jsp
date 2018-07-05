<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 14.05.2018
  Time: 16:05
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
    <form:form action="/add/country" method="post" modelAttribute="countryModel">
        <form:errors path="*" cssClass="error"/>
        Name <form:input path="name"/><form:errors path="name" cssClass="error"/><br>
        Short Name <form:input path="shortName"/><form:errors path="shortName" cssClass="error"/><br>
        <button type="submit">Add country</button>
    </form:form>

</body>
</html>
