<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 20.06.2018
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <%@ include file="/WEB-INF/includes/css-incl.jsp"%>
    <link href="https://fonts.googleapis.com/css?family=Russo+One" rel="stylesheet">
    <title>Title</title>
    <style>
        th{
            text-align: center;
        }
        .well{
            width: 750px;
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
        .mod1{
            margin: 0 50px;
        }
    </style>
</head>
<body>
    <c:url var="firstUrl" value="/admin/users/search?page=0&searchFullName=${fullName}&searchAge=${age}&searchEmail=${email}&searchCountry=${country}&size=${size}"/>
    <c:url var="lastUrl" value="/admin/users/search?page=${pages.totalPages-1}&searchFullName=${fullName}&searchAge=${age}&searchEmail=${email}&searchCountry=${country}&size=${size}"/>

    <c:url var="nextUrl" value="/admin/users/search?page=${currentPage + 1}&searchFullName=${fullName}&searchAge=${age}&searchEmail=${email}&searchCountry=${country}&size=${size}"/>
    <c:url var="prevUrl" value="/admin/users/search?page=${currentPage - 1}&searchFullName=${fullName}&searchAge=${age}&searchEmail=${email}&searchCountry=${country}&size=${size}"/>
    <nav class="navigation">
        <menu class="menu">
            <a href="/" class="menuLink">Home Page</a>
            <a href="/articles" class="menuLink">Articles</a>
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
            <form:form modelAttribute="filter" action="/admin/users/search" method="get">
                <div class="mod1">
                    <div class="col-md-4">
                        <div class="form-group">
                            <div class="serchtile">Full Name</div>
                            <form:input path="searchFullName" class="form-control"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <div class="serchtile">Age</div>
                            <form:input path="searchAge" class="form-control"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <div class="serchtile">Email</div>
                            <form:input path="searchEmail" class="form-control"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <div class="serchtile">Country</div>
                            <form:input path="searchCountry" class="form-control"/>
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
    </main>
        <div class="well">
            <table class="table">
                <thead>
                    <tr>
                        <th>FULL NAME</th>
                        <th>AGE</th>
                        <th>EMAIL</th>
                        <th>COUNTRY</th>
                        <th>INFO</th>
                        <th>EDIT</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.fullName}</td>
                            <td>${user.age}</td>
                            <td>${user.email}</td>
                            <td>${user.country}</td>
                            <td><a href="/admin/users/info/${user.id}">Info</a></td>
                            <td><a href="/admin/users/edit/${user.id}">Edit</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
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
                <c:url var="pageUrl" value="/admin/users/search?page=${i}&searchFullName=${fullName}&searchAge=${age}&searchEmail=${email}&searchCountry=${country}&size=${size}"/>
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
        </div>
</body>
</html>
