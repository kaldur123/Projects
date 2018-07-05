<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 16.05.2018
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form modelAttribute="filterModel" action="/students/search" method="get">
        <form:input path="search"/>
        <button type="submit">Search</button>
    </form:form>
    <ul>
        <c:forEach items="${studentList}" var="student">
            <li>
                ${student.id} | ${student.firstName} | ${student.lastName} | ${student.age}
            </li>
        </c:forEach>
    </ul>
</body>
</html>
