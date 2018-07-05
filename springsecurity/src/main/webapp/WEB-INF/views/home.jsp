<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 31.05.2018
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Welcome to the Hospital</h2>
    <c:url var="firstUrl" value="/?page=0"/>
    <c:url var="lastUrl" value="/?page=${pages.totalPages-1}"/>

    <c:url var="nextUrl" value="/?page=${currentPage + 1}"/>
    <c:url var="prevUrl" value="/?page=${currentPage - 1}"/>
    <div class="container">
        <div class="row">
            <div class="panel panel-primary filterable">
                <div class="panel-heading">
                    <h3 class="panel-title"><div class="mod"><div class="users">Users</div><div class="but"></div></div></h3>
                </div>

                <table class="table table-bordered">
                    <tr>
                        <th>Id</th>
                        <th>Login</th>
                        <th>Info</th>
                    </tr>
                    <c:forEach items="${userList}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.login}</td>
                            <td><a href="/info/${user.id}" class="btn btn-default">Info</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="text-center">
                    <ul class="pagination">
                        <c:choose>
                            <c:when test="${currentPage == 0}">
                                <li class="disabled"><a href="#">&lt;&lt;</a></li>
                                <li class="disabled"><a href="#">&lt;</a> </li>
                                <li ><a href="${firstUrl}">1</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${firstUrl}">&lt;&lt;</a></li>
                                <li><a href="${prevUrl}">&lt;</a></li>
                            </c:otherwise>
                        </c:choose>

                        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                            <c:url var="pageUrl" value="/?page=${i}"/>
                            <c:choose>
                                <c:when test="${i == currentPage}">
                                    <li class="active"><a href="#">${i+1}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="${pageUrl}">${i+1}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>


                        <c:choose>
                            <c:when test="${currentPage == pages.totalPages-1}">
                                <li class="disabled"><a href="#">&gt;</a></li>
                                <li class="disabled"><a href="#">&gt;&gt;</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${nextUrl}">&gt;</a></li>
                                <li><a href="${lastUrl}">&gt;&gt;</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </div>
        <sec:authorize access="!isAuthenticated()">
            <a href="/login">Go to login</a>
            <a href="/register">Go to register</a>
        </sec:authorize>
    </div>
</body>
</html>
