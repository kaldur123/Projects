<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 16.05.2018
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <%--<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" >--%>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css" id="bootstrap-css">
    <title>Title</title>
    <style>
        .form-section{
            background:rgba(0,0,0,0.6);
            border: 2px solid #414141;
            border-radius: 5px;
            padding: 10px;
            margin-top: 7px;
        }
        .serchtile{
            color:#fff;
            font-size: 15px;
        }
        .filterable {
            margin-top: 15px;
        }
        .filter {
            position: absolute;
            display: none;
            color: black;
            margin-left: -1000px;
            margin-top: -7px;
        }
        .but:hover .filter{
            display: block;
        }
        .but:hover{
            color:red;
        }
        .mod{
            display: flex;
            justify-content: space-between;
        }
        .mod1{
            display: flex;

            justify-content: space-between;
        }
        .form-control{
            width: 120px;
        }
        .users{
            font-family: "Times New Roman", Times, serif;
            font-size: 25px;
        }
        .size{
             width: 50px;
         }
    </style>
</head>
<body>
    <c:url var="firstUrl" value="/users/search?page=0&searchFirstName=${firstName}&searchLastName=${lastName}&searchEmail=${email}&searchLogin=${login}&searchMinSalary=${minsalary}&searchMaxSalary=${maxsalary}&size=${size}"/>
    <c:url var="lastUrl" value="/users/search?page=${pages.totalPages-1}&searchFirstName=${firstName}&searchLastName=${lastName}&searchEmail=${email}&searchLogin=${login}&searchMinSalary=${minsalary}&searchMaxSalary=${maxsalary}&size=${size}"/>

    <c:url var="nextUrl" value="/users/search?page=${currentPage + 1}&searchFirstName=${firstName}&searchLastName=${lastName}&searchEmail=${email}&searchLogin=${login}&searchMinSalary=${minsalary}&searchMaxSalary=${maxsalary}&size=${size}"/>
    <c:url var="prevUrl" value="/users/search?page=${currentPage - 1}&searchFirstName=${firstName}&searchLastName=${lastName}&searchEmail=${email}&searchLogin=${login}&searchMinSalary=${minsalary}&searchMaxSalary=${maxsalary}&size=${size}"/>
    <div class="container">
        <div class="row">
            <div class="panel panel-primary filterable">
                <div class="panel-heading">
                    <h3 class="panel-title"><div class="mod"><div class="users">Users</div><div class="but"><div class="btn btn-default">Filter</div>
                        <div class="filter">
                            <div class="form-section">
                                <div class="row">
                                    <form:form modelAttribute="myFilter" action="/users/search" method="get" role="form">
                                        <div class="mod1">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <div class="serchtile">First Name</div>
                                                <form:input path="searchFirstName" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <div class="serchtile">Last Name</div>
                                                <form:input path="searchLastName" class="form-control"/>
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
                                                <div class="serchtile">Login</div>
                                                <form:input path="searchLogin" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <div class="serchtile">Minimal Salary</div>
                                                <form:input path="searchMinSalary" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <div class="serchtile">Maximal Salary</div>
                                                <form:input path="searchMaxSalary" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-md-2">
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
                            </div>
                        </div>
                    </div></div></h3>
                </div>

                <table class="table table-bordered">
                    <tr>
                        <th>Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Login</th>
                        <th>Salary</th>
                        <th>Load image</th>
                        <th>Info</th>
                    </tr>
                    <c:forEach items="${userList}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.email}</td>
                            <td>${user.login}</td>
                            <td>${user.salary}</td>
                            <td>
                                <form:form action="/users/${user.id}" method="post" enctype="multipart/form-data" modelAttribute="photo">
                                    <input type="file" name="file" class="btn btn-large"/>
                                    <button type="submit">Load</button>
                                </form:form>
                            </td>
                            <td><a href="/users/info/${user.id}" class="btn btn-default">Info</a></td>
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
                            <c:url var="pageUrl" value="/users/search?page=${i}&searchFirstName=${firstName}&searchLastName=${lastName}&searchEmail=${email}&searchLogin=${login}&searchMinSalary=${minsalary}&searchMaxSalary=${maxsalary}&size=${size}"/>
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
    </div>
    <h2 class="text-center"><a href="/">Home</a></h2>
</body>
</html>
