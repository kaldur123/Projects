<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 19.06.2018
  Time: 16:40
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
            width: 550px;
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
        .btn3d {
            position:relative;
            top: -6px;
            border:0;
            transition: all 40ms linear;
            margin-top:10px;
            margin-bottom:10px;
            margin-left:2px;
            margin-right:2px;
        }
        .btn3d:active:focus,
        .btn3d:focus:hover,
        .btn3d:focus {
            -moz-outline-style:none;
            outline:medium none;
        }
        .btn3d:active, .btn3d.active {
            top:2px;
        }
        .btn3d.btn-white {
            color: #666666;
            box-shadow:0 0 0 1px #ebebeb inset, 0 0 0 2px rgba(255,255,255,0.10) inset, 0 8px 0 0 #f5f5f5, 0 8px 8px 1px rgba(0,0,0,.2);
            background-color:#fff;
        }
        .btn3d.btn-white:active, .btn3d.btn-white.active {
            color: #666666;
            box-shadow:0 0 0 1px #ebebeb inset, 0 0 0 1px rgba(255,255,255,0.15) inset, 0 1px 3px 1px rgba(0,0,0,.1);
            background-color:#fff;
        }
        .btn3d.btn-default {
            color: #666666;
            box-shadow:0 0 0 1px #ebebeb inset, 0 0 0 2px rgba(255,255,255,0.10) inset, 0 8px 0 0 #BEBEBE, 0 8px 8px 1px rgba(0,0,0,.2);
            background-color:#f9f9f9;
        }
        .btn3d.btn-default:active, .btn3d.btn-default.active {
            color: #666666;
            box-shadow:0 0 0 1px #ebebeb inset, 0 0 0 1px rgba(255,255,255,0.15) inset, 0 1px 3px 1px rgba(0,0,0,.1);
            background-color:#f9f9f9;
        }
        .btn3d.btn-primary {
            box-shadow:0 0 0 1px #417fbd inset, 0 0 0 2px rgba(255,255,255,0.15) inset, 0 8px 0 0 #4D5BBE, 0 8px 8px 1px rgba(0,0,0,0.5);
            background-color:#4274D7;
        }
        .btn3d.btn-primary:active, .btn3d.btn-primary.active {
            box-shadow:0 0 0 1px #417fbd inset, 0 0 0 1px rgba(255,255,255,0.15) inset, 0 1px 3px 1px rgba(0,0,0,0.3);
            background-color:#4274D7;
        }
        .btn3d.btn-success {
            box-shadow:0 0 0 1px #31c300 inset, 0 0 0 2px rgba(255,255,255,0.15) inset, 0 8px 0 0 #5eb924, 0 8px 8px 1px rgba(0,0,0,0.5);
            background-color:#78d739;
        }
        .btn3d.btn-success:active, .btn3d.btn-success.active {
            box-shadow:0 0 0 1px #30cd00 inset, 0 0 0 1px rgba(255,255,255,0.15) inset, 0 1px 3px 1px rgba(0,0,0,0.3);
            background-color: #78d739;
        }
        .btn3d.btn-info {
            box-shadow:0 0 0 1px #00a5c3 inset, 0 0 0 2px rgba(255,255,255,0.15) inset, 0 8px 0 0 #348FD2, 0 8px 8px 1px rgba(0,0,0,0.5);
            background-color:#39B3D7;
        }
        .btn3d.btn-info:active, .btn3d.btn-info.active {
            box-shadow:0 0 0 1px #00a5c3 inset, 0 0 0 1px rgba(255,255,255,0.15) inset, 0 1px 3px 1px rgba(0,0,0,0.3);
            background-color: #39B3D7;
        }
        .btn3d.btn-warning {
            box-shadow:0 0 0 1px #d79a47 inset, 0 0 0 2px rgba(255,255,255,0.15) inset, 0 8px 0 0 #D79A34, 0 8px 8px 1px rgba(0,0,0,0.5);
            background-color:#FEAF20;
        }
        .btn3d.btn-warning:active, .btn3d.btn-warning.active {
            box-shadow:0 0 0 1px #d79a47 inset, 0 0 0 1px rgba(255,255,255,0.15) inset, 0 1px 3px 1px rgba(0,0,0,0.3);
            background-color: #FEAF20;
        }
        .btn3d.btn-danger {
            box-shadow:0 0 0 1px #b93802 inset, 0 0 0 2px rgba(255,255,255,0.15) inset, 0 8px 0 0 #AA0000, 0 8px 8px 1px rgba(0,0,0,0.5);
            background-color:#D73814;
        }
        .btn3d.btn-danger:active, .btn3d.btn-danger.active {
            box-shadow:0 0 0 1px #b93802 inset, 0 0 0 1px rgba(255,255,255,0.15) inset, 0 1px 3px 1px rgba(0,0,0,0.3);
            background-color: #D73814;
        }
        .btn3d.btn-magick {
            color: #fff;
            box-shadow:0 0 0 1px #9a00cd inset, 0 0 0 2px rgba(255,255,255,0.15) inset, 0 8px 0 0 #9823d5, 0 8px 8px 1px rgba(0,0,0,0.5);
            background-color:#bb39d7;
        }
        .btn3d.btn-magick:active, .btn3d.btn-magick.active {
            box-shadow:0 0 0 1px #9a00cd inset, 0 0 0 1px rgba(255,255,255,0.15) inset, 0 1px 3px 1px rgba(0,0,0,0.3);
            background-color: #bb39d7;
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
                <a href="/user" class="menuLink button">My Cabinet</a>
            </sec:authorize>
        </sec:authorize>
    </menu>
</nav>
<main class="main">
    <section class="section">
        <h2>Personal Cabinet</h2>
        <h3>Hello, ${userProfile.fullName}</h3>
    <a href="/user/info" class="btn btn-info btn-lg btn3d"><span class="glyphicon glyphicon-question-sign"></span>Info</a><br>
    <a href="/user/edit" class="btn btn-magick btn-lg btn3d"><span class="glyphicon"></span>Edit profile</a><br>
    <a href="/user/add-article" class="btn btn-success btn-lg btn3d"><span class="glyphicon"></span>Add article</a><br>
    <a href="/user/my-articles" class="btn btn-warning btn-lg btn3d"><span class="glyphicon"></span>Show my articles</a><br>
    <form:form action="/logout" method="post">
        <button type="submit" class="btn btn-danger btn-lg btn3d"><span class="glyphicon glyphicon-off"></span>Logout</button>
    </form:form>
    </section>
</main>
</body>
</html>
