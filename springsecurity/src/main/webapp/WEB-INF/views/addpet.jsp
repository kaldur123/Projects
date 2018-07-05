<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 04.06.2018
  Time: 5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="/client/addpet" method="post" modelAttribute="pet">
        Type <form:input path="type"/><br>
        Age <form:input path="age"/><br>
        Name <form:input path="name"/><br>
        Color <form:input path="color"/><br>
        Weight <form:input path="weight"/><br>
        <button type="submit">Add</button>
    </form:form>
</body>
</html>
