<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 19.06.2018
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <sec:authorize access="isAuthenticated()">
        <%--<sec:authentication property="principal.username" var="user">--%>
            <%--Hello, ${user}<br>--%>
        <%--</sec:authentication>--%>

        <form:form action="/logout" method="post">
            <button type="submit">Logout</button>
        </form:form>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        Hello, I am Anonimus<br>
        <a href="/login">Login</a><br>
        <a href="/register">Register</a>
    </sec:authorize>
    <a href="/articles">Show all articles</a>
</body>
</html>
