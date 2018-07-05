<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 19.06.2018
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    User Page<br>
    Hello, ${userProfile.fullName}<br>
    <a href="/user/info">Info</a><br>
    <a href="/user/edit">Edit profile</a>
    <a href="/user/add-article">Add article</a><br>
    <a href="/user/my-articles">Show my articles</a><br>
    <form:form action="/logout" method="post">
        <button type="submit">Logout</button>
    </form:form>

</body>
</html>
