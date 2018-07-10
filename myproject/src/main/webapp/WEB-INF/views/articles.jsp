<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 26.06.2018
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/includes/css-incl.jsp"%>
    <link href="https://fonts.googleapis.com/css?family=Russo+One" rel="stylesheet">
    <style>
    th{
        text-align: center;
    }
    .well{
        width: 600px;
        margin: 0 auto;
        background-color: #bfbebe;
    }
    *{
        margin: 0;
        padding: 0;
        text-align: center;
        font-family: 'Russo One', sans-serif;
    }
    body {
        background-image: url("http://res.cloudinary.com/hercules/image/upload/v1531147471/body/bg.jpg");
        background-attachment: fixed;
        background-size: cover;
    }
    .main{
        width: 750px;
        margin: 0 auto;
        background-image: url("https://res.cloudinary.com/hercules/image/upload/v1531148908/body/bg_content.png");
        background-color: red;
        padding-top: 5px;
        padding-bottom: 20px;
        color: #2ad2a3;
        font-family: 'Ubuntu',"Trebuchet MS",Trebuchet,Verdana,Helvetica,Arial,sans-serif;
    }
    .navigation{
        margin-top: 20px;
    }
    .menu{
        width: 750px;
        display: flex;
        height: 40px;
        background-image: url("https://res.cloudinary.com/hercules/image/upload/v1531151281/body/bg_menu.png");
        background-size: contain;
        background-repeat: no-repeat;
        margin: 0 auto 150px;
        justify-content: space-around;
        align-items: center;
    }
    .menuLink{
        width: 100px;
        height: 40px;
        text-decoration: none;
        line-height: 40px;
        float: left;
        margin-left: 20px;
        color: aquamarine;
        font-size: 12pt;
    }
    .menuLink:hover{
        background-size: contain;
        background: url("https://res.cloudinary.com/hercules/image/upload/v1531151979/body/menu_hover.png") no-repeat 100%;
        color: aliceblue;
        text-decoration: none;
    }
    .button{
        background-size: contain;
        background: url("https://res.cloudinary.com/hercules/image/upload/v1531151979/body/menu_hover.png") no-repeat 100%;
        color: aliceblue;
    }
    .flex-container {
        display: flex;
        justify-content: flex-end;
    }
    </style>
</head>
<body>
<c:url var="firstUrl" value="/articles/search?page=0&searchTitle=${title}&searchDinoName=${dinoName}&size=${size}"/>
<c:url var="lastUrl" value="/articles/search?page=${pages.totalPages-1}&searchTitle=${title}&searchDinoName=${dinoName}&size=${size}"/>

<c:url var="nextUrl" value="/articles/search?page=${currentPage + 1}&searchTitle=${title}&searchDinoName=${dinoName}&size=${size}"/>
<c:url var="prevUrl" value="/articles/search?page=${currentPage - 1}&searchTitle=${title}&searchDinoName=${dinoName}&size=${size}"/>
<nav class="navigation">
    <menu class="menu">
        <a href="/" class="menuLink">Home Page</a>
        <a href="/articles" class="menuLink button">Articles</a>
        <sec:authorize access="!isAuthenticated()">
            <a href="/login" class="menuLink">Login</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <sec:authorize access="hasRole('ADMIN')">
                <a href="/admin" class="menuLink">My Cabinet</a>
            </sec:authorize>
            <sec:authorize access="hasRole('USER')">
                <a href="/user" class="menuLink">My Cabinet</a>
            </sec:authorize>
        </sec:authorize>
    </menu>
</nav>
<main class="main">
    <div class="row flex-container">
    <form:form modelAttribute="filter" action="/articles/search" method="get">
        <div class="mod1">
            <div class="col-md-3">
                <div class="form-group">
                    <div class="serchtile">Title</div>
                    <form:input path="searchTitle" class="form-control"/>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <div class="serchtile">Dino Name</div>
                    <form:input path="searchDinoName" class="form-control"/>
                </div>
            </div>
            <div class="col-md-1">
                <div class="form-group">
                    <div class="serchtile">Size</div>
                    <div class="input-group">
                        <form:select path="size" class="size">
                            <form:options items="${count}"/>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="col-md-2 text-center">
                <br>
                <button type="submit" class="btn btn-default btn-primary">Search</button>
            </div>
        </div>
    </form:form>
</div>
    <div class="well">
        <table class="table">
                <tr>
                    <th>Title</th>
                    <th>Dino Name</th>
                </tr>
            <c:forEach items="${articles}" var="article">
                <tr>
                    <td><a href="/articles/${article.id}">${article.title}</a></td>
                    <td><a href="/articles/dino/${article.dino.id}">${article.dino.name}</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <ul class="pagination">
        <c:choose>
            <c:when test="${currentPage == 0}">
                <li class="disabled"><a href="#">&lt;&lt;</a></li>
                <li class="disabled"><a href="#">&lt;</a></li>
                <li class="active"><a href="${firstUrl}">1</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${firstUrl}">&lt;&lt;</a></li>
                <li><a href="${prevUrl}">&lt;</a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            <c:url var="pageUrl" value="/articles/search?page=${i}&searchTitle=${title}&searchDinoName=${dinoName}&size=${size}"/>
            <c:choose>
                <c:when test="${i == currentPage}">
                    <li class="active"><a href="#">${i+1}</a></li>
                </c:when>
                <%--<c:otherwise>--%>
                <%--<li><a href="${pageUrl}">${i+1}</a></li>--%>
                <%--</c:otherwise>--%>
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
</main>
</body>
</html>
