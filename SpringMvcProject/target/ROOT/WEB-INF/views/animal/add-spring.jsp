<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 07.05.2018
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="${rootURL}/animal/add-spring" method="post" modelAttribute="animalModel">
        <form:input path="name"/><br>
        <form:input path="kind"/><br>
        <input type="submit" value="Add animal">
    </form:form>
</body>
</html>
