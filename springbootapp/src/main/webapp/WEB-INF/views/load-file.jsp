<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 21.05.2018
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="/upload/db" method="post" modelAttribute="loadFileModel" enctype="multipart/form-data">
        <input type="file" name="loadFile"><br>
        <button type="submit">Load</button>
    </form:form>
</body>
</html>
