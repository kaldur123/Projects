<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 04.06.2018
  Time: 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/client/edit">Edit</a><br>
    <form:form action="/client" method="post" enctype="multipart/form-data" modelAttribute="client">
        <input type="file" name="file" class="btn btn-large"/>
        <button type="submit">Load</button>
    </form:form><br>
    <a href="/client/addpet">Add Pet</a><br>
    <a href="/client/editpet">Edit Pet</a><br>
    <a href="/client/allvisits">See all visits to the doctor</a>
</body>
</html>
