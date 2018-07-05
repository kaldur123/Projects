<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 18.05.2018
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
    <c:url var="firstUrl" value="/users/pages?page=0"/>
    <c:url var="lastUrl" value="/student/pages?page=${studentsList.totalPages - 1}"/>

    <c:url var="nextUrl" value="/student/pages?page=${currentPage + 1}"/>
    <c:url var="prevUrl" value="/student/pages?page=${currentPage - 1}"/>
    <div class="container">
        <div class="row">
            <ul class="pagination">
                <c:choose>
                    <c:when test="${currentPage == 0}">
                        <li class="disabled"><a href="#">&lt;&lt;</a></li>
                        <li class="disabled"><a href="#">&lt;</a> </li>
                        <li class="active"><a href="${firstUrl}"> 1 </a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${firstUrl}">&lt;&lt;</a></li>
                        <li><a href="${prevUrl}">&lt;</a></li>
                    </c:otherwise>
                </c:choose>

                <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                    <c:url var="pageUrl" value="/student/pages?page=${i}"/>
                    <c:choose>
                        <c:when test="${i == currentPage}">
                            <li class="active"><a href="#">${i + 1}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${pageUrl}">${i + 1}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:choose>
                    <c:when test="${currentPage + 1 == studentsList.totalPages}">
                        <li class="disabled">
                            <a href="#">&gt;</a>
                        </li>
                        <li class="disabled"><a href="#">&gt;&gt;</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${nextUrl}">&gt;</a></li>
                        <li><a href="${lastUrl}">&gt;&gt;</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Age</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${studentsListBySize}" var="student">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>${student.age}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
