<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 04.06.2018
  Time: 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/client/editpet/image/${petImg.id}" method="post" enctype="multipart/form-data" modelAttribute="petImg">
    <input type="file" name="img" class="btn btn-large"/>
    <button type="submit">Load</button>
</form:form>
</body>
</html>
