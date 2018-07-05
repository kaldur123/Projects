<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 26.06.2018
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <%--<sec:authorize access="hasRole('USER')">--%>
            <form:form action="/user/edit" method="post" modelAttribute="user" >
                <form:errors path="*" cssClass="error"/>
                Full Name: <form:input path="fullName"/><br>
                <%--Full Name: <input name="fullName" value="${user.fullName}"/><br>--%>
                Age: <form:select path="age">
                <c:forEach items="${nums}" var="num">
                    <form:option value="${num}">${num}</form:option>
                </c:forEach>
            </form:select><br>
                Country: <form:select path="country">
                <form:options items="${countries}"/>
            </form:select><br>
                <button type="submit" class="btn btn-info">Edit</button>
            </form:form>
        <%--</sec:authorize>--%>
        <%--<sec:authorize access="hasRole('ADMIN')">--%>
            <%--<form:form action="/admin/users/edit/${userId}" method="post" modelAttribute="user" >--%>
                <%--<form:errors path="*" cssClass="error"/>--%>
                <%--Full Name: <form:input path="fullName"/><br>--%>
                <%--Age: <form:select path="age">--%>
                <%--<c:forEach items="${nums}" var="num">--%>
                    <%--<form:option value="${num}">${num}</form:option>--%>
                <%--</c:forEach>--%>
            <%--</form:select><br>--%>
                <%--Country: <form:select path="country">--%>
                <%--<form:options items="${countries}"/>--%>
            <%--</form:select><br>--%>
                <%--<button type="submit" class="btn btn-info">Edit</button>--%>
            <%--</form:form>--%>
        <%--</sec:authorize>--%>
    </div>
</body>
</html>
