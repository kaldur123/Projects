<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 04.06.2018
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="/client/visit/${pet.id}" method="post" modelAttribute="appoint">
        Complaint <form:input path="complaint"/><br>
        Date Inform <form:input path="dateInp" type="date"/><br>
        <button type="submit">Add appointment</button>
    </form:form>
</body>
</html>
