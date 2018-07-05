<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 07.05.2018
  Time: 3:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <link rel="stylesheet" href="${rootURL}/resources/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>

    <div class="container">
        <table class="table table-striped custab">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Kind</th>
                    <th>Gender</th>
                    <th class="text-center">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${animalList}" var="animal">
                    <tr>
                        <td>${animal.id}</td>
                        <td><a href="${rootURL}/animal/name?animalName=${animal.name}">${animal.name}</a></td>
                        <td>${animal.kind}</td>
                        <td>${animal.gender}</td>
                        <td class="text-center">
                            <a class='btn btn-info btn-xs' href="${rootURL}/animal/info/${animal.id}">
                                <span class="glyphicon glyphicon-edit"></span> Info</a>
                            <a href="${rootURL}/animal/edit/${animal.id}">Edit</a>
                            <a href="${rootURL}/animal/delete/${animal.id}" class="btn btn-danger btn-xs">
                                <span class="glyphicon glyphicon-remove"></span> Del</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


</body>
</html>
