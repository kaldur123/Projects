<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 20.06.2018
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    User List
    <table>
        <thead>
            <tr>
                <th>FULL NAME</th>
                <th>AGE</th>
                <th>EMAIL</th>
                <th>EDIT</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.fullName}</td>
                    <td>${user.age}</td>
                    <td>${user.email}</td>
                    <td><a href="/admin/users/info/${user.id}">Info</a></td>
                    <td><a href="/admin/users/edit/${user.id}">Edit</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
