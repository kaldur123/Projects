<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 07.05.2018
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Edit</title>
</head>
<body>
    <form:form action="${rootURL}/animal/edit" method="post" modelAttribute="editAnimalModel">
        <%--<form:hidden path="id"/>--%>
        Name: <form:input path="name"/>
        Kind: <form:input path="kind"/>
    </form:form>
</body>
</html>
