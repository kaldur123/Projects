<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 09.05.2018
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <%--<c:choose>--%>
        <%--<c:when test="${title==null}">--%>
            <%--<tiles:putAttribute name="title" value="App Title"/>--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
            <%--<tiles:putAttribute name="title" value="${title}"/>--%>
        <%--</c:otherwise>--%>
    <%--</c:choose>--%>
        <c:if test="${title != null}">
            <tiles:putAttribute name="title" value="${title}"/>
        </c:if>
    <title><tiles:getAsString name="title"/></title>
    <link rel="stylesheet" href="${rootURL}/resources/css/bootstrap.min.css">
</head>
<body>

        <tiles:insertAttribute name="header"/>
        <div class="container">
            <tiles:insertAttribute name="body"/>
        </div>
        <tiles:insertAttribute name="footer"/>
</body>
</html>
