<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 04.06.2018
  Time: 6:21
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
        <tr>
            <th>Id</th>
            <th>Type</th>
            <th>Age</th>
            <th>Name</th>
            <th>Color</th>
            <th>Weight</th>
            <th>Edit</th>
            <%--<th>Image</th>--%>
        </tr>
        <c:forEach items="${pets}" var="pet">
            <tr>
                <td>${pet.id}</td>
                <td>${pet.type}</td>
                <td>${pet.age}</td>
                <td>${pet.name}</td>
                <td>${pet.color}</td>
                <td>${pet.weight}</td>
                <td><a href="/client/editpet/${pet.id}" class="btn btn-default">Edit</a></td>
                <%--<td><img alt="User Pic" src="data:image/png;base64, ${imgSrc}" width="200" height="210"></td>--%>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
