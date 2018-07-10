<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 04.07.2018
  Time: 23:01
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
    </style>
</head>
<body>
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
    <section class="section">
        <h2>Error happened</h2>

        Url: ${url} <br>
        Request method: ${httpMethod} <br>
        Error message: ${exception.message}
    </section>
</main>
</body>
</html>
