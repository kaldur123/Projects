<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 04.06.2018
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table">
    <tbody>
    <tr>
        <td>Login:</td>
        <td>${doc.login}</td>
    </tr>
    <tr>
        <td>Phone Number:</td>
        <td>${doc.phoneNumber}</td>
    </tr>
    <tr>
        <td>BirthDate:</td>
        <td>${doc.date}</td>
    </tr>
    <tr>
        <td>Address:</td>
        <td>${doc.address}</td>
    </tr>
    <tr>
        <img alt="User Pic" src="data:image/png;base64, ${imgSrc}" width="300" height="310">
    </tr>
    </tbody>
</table>
</body>
</html>
