<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 18.06.2018
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Login Page
    <form:form action="/login" method="post">
        Login: <input type="text" name="email"/><br>
        Password: <input type="password" name="password"/><br>
        Remember me <input type="checkbox" name="rememberMe"/><br>
        <button type="submit">Login</button>
    </form:form>
</body>
</html>
