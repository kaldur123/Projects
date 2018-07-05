<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 09.05.2018
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <title>User Information</title>
</head>
<body>
    <div class="container">

        <h1>User Detail</h1>
        <br />

        <div class="row">
            <label class="col-sm-2">ID</label>
            <div class="col-sm-10">${userInfo.id}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Full Name</label>
            <div class="col-sm-10">${userInfo.fullName}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Age</label>
            <div class="col-sm-10">${userInfo.age}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Country</label>
            <div class="col-sm-10">${userInfo.country}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Gender</label>
            <div class="col-sm-10">${userInfo.gender}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Email</label>
            <div class="col-sm-10">${userInfo.email}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Degree</label>
            <div class="col-sm-10">${userInfo.degree}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Social Networks</label>
            <div class="col-sm-10"><c:forEach items="${userInfo.socNet}" var="socNet" varStatus="loop">
                ${socNet}
                <c:if test="${not loop.last}">,</c:if>
            </c:forEach>
                </div>
        </div>

        <div class="row">
            <label class="col-sm-2">Favorite Programming Language</label>
            <div class="col-sm-10">${userInfo.favoriteProgrammingLanguage}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Operation Systems</label>
            <div class="col-sm-10"><c:forEach items="${userInfo.os}" var="os" varStatus="loop">
                ${os}
                <c:if test="${not loop.last}">,</c:if>
            </c:forEach></div>
        </div>

        <div class="row">
            <label class="col-sm-2">Programming Experience</label>
            <div class="col-sm-10">${userInfo.programmingExperience}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Rank</label>
            <div class="col-sm-10">${userInfo.rank}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Technologies</label>
            <div class="col-sm-10"><c:forEach items="${userInfo.technologies}" var="technologies" varStatus="loop">
                ${technologies}
                <c:if test="${not loop.last}">,</c:if>
            </c:forEach></div>
        </div>

        <div class="row">
            <label class="col-sm-2">Information Source</label>
            <div class="col-sm-10">${userInfo.informationSource}</div>
        </div>

    </div>
</body>
</html>
