<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 18.06.2018
  Time: 18:44
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
        * {
            margin: 0;
            padding: 0;
            text-align: center;
            font-family: 'Russo One', sans-serif;
        }
        table{
            margin: 0 auto;
            color: #5bc0de;
        }
        td{
            padding: 10px;
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
            padding-top: 20px;
            padding-bottom: 20px;
            color: #5bc0de;
            font-family: 'Ubuntu',"Trebuchet MS",Trebuchet,Verdana,Helvetica,Arial,sans-serif;
        }
        h2{
            margin-bottom: 20px;
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
            margin: 0 auto 100px;
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
            background-image: url("https://res.cloudinary.com/hercules/image/upload/v1531151979/body/menu_hover.png");
            background-size: contain;
            background-repeat: no-repeat;
            background-position: 100%;
            color: aliceblue;
            text-decoration: none;
        }
        .button{
            background-image: url("https://res.cloudinary.com/hercules/image/upload/v1531151979/body/menu_hover.png");
            background-size: contain;
            background-repeat: no-repeat;
            background-position: 100%;
            color: aliceblue;
        }
        button{
            color: black;
        }
        .pass{
            color: black;
        }
    </style>
</head>
<body>
    <nav class="navigation">
        <menu class="menu">
            <a href="/" class="menuLink">Home Page</a>
            <a href="/articles" class="menuLink">Articles</a>
            <sec:authorize access="!isAuthenticated()">
                <a href="/login" class="menuLink button">Login</a>
            </sec:authorize>
            <%--<sec:authorize access="isAuthenticated()">--%>
                <%--<sec:authorize access="hasRole('ADMIN')">--%>
                    <%--<a href="/admin" class="menuLink">My Cabinet</a>--%>
                <%--</sec:authorize>--%>
                <%--<sec:authorize access="hasRole('USER')">--%>
                    <%--<a href="/user" class="menuLink">My Cabinet</a>--%>
                <%--</sec:authorize>--%>
            <%--</sec:authorize>--%>
        </menu>
    </nav>
    <main class="main">
        <section class="section">
            <h2>Login Page</h2>
            <form:form action="/login" method="post">
                <table>
                    <tr>
                        <td>Login:</td>
                        <td><input type="text" name="email"/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td class="pass"><input type="password" name="password"/></td>
                    </tr>
                </table>
                Remember me <input type="checkbox" name="rememberMe"/><br>
                <button type="submit">Login</button>
            </form:form>
            If you are not registered:
            <a href="/register" class="btn button">Register</a>
        </section>
    </main>
    
    
</body>
</html>
