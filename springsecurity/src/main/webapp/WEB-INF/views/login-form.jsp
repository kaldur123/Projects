<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 03.06.2018
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form:form action="/login" method="post">
        Login: <input type="text" name="login"><br>
        Password: <input type="password" name="password"><br>
        <button type="submit">Login</button>
    </form:form>
</body>
</html>
