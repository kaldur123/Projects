<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 26.06.2018
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <%--<meta name="csrf-token" content="${_csrf.token}">--%>
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
            color: #34a9e0;
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
        .error{
            color: red;
            border-color: red;
        }
        p{
            text-align: justify;
            margin-left: 40px;
        }
        h3{
            margin-left: 40px;
            text-align: justify;
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
    <div id="app">
        <h1>${article.title}</h1>
        <p>${article.description}</p>
        <br>
        <br>
        <br>
            <sec:authorize access="hasRole('ADMIN')">
                <form:form action="/articles/${article.id}/delete" method="post" modelAttribute="article">
                    <button type="submit" class="btn btn-danger btn3d"><span class="glyphicon glyphicon-remove"></span>Delete</button>
                </form:form>
            </sec:authorize>
            <sec:authorize access="hasRole('USER')">
                <c:choose>
                    <c:when test="${testId == article.writer.id}">
                        <form:form action="/articles/${article.id}/delete" method="post" modelAttribute="article">
                            <button type="submit" class="btn btn-danger btn3d"><span class="glyphicon glyphicon-remove"></span>Delete</button>
                        </form:form>
                    </c:when>
                </c:choose>
            </sec:authorize>
        <h2>Comments</h2>
        <div v-for="comment in comments">
            <h3>{{comment.writerName}}</h3>
            <p>{{comment.text}}</p>
        </div>
        Add you comment:
            <sec:authorize access="isAuthenticated()">
                <input type="text" :class="{error: isError}" name="text" v-model="comment.content"/>
                <input type="hidden" id="csrf" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button @click="saveComment()" type="submit">Add comment</button><br>
                <label class="control-label" :class="{error: isError}" v-if="isError">This field is empty</label>
            </sec:authorize>
           <sec:authorize access="!isAuthenticated()">
               <a href="/login">Login</a>
           </sec:authorize>
    </div>
</main>
    <%@ include file="/WEB-INF/includes/js-incl.jsp"%>
    <script type="text/javascript">
        new Vue({
            el: "#app",
            data: {
                // rootUrl: "http://localhost:8080/rest",
                rootUrl: "https://fathomless-tor-42836.herokuapp.com/rest",
                comments: [],
                comment: {
                    content: "",
                    writerName: "${writerName}"
                },
                isError: false,
                csrf: ""
            },
            methods: {
                getComments() {
                    axios.get(this.rootUrl + "/articles/" + ${article.id})
                        .then((resp) => {
                            console.log("Success" + resp.data);
                            this.comments = resp.data;
                        })
                        .catch((err) => {
                            console.log(err.response.data);
                        })
                },
                saveComment() {
                    // this.comment = document.getElementsByName("text").valueOf();
                    if ("${writerName}" != "") {
                        this.csrf = document.querySelector('#csrf').getAttribute("value");
                    }
                    if (this.comment.content === "") {
                        this.isError = true;
                        return;
                    }

                    let formData = new FormData();
                    formData.append("${_csrf.parameterName}", this.csrf);
                    formData.append("text", this.comment.content);

                    axios.post(this.rootUrl + "/articles/" + ${article.id} + "/save-comment", formData)
                        .then((resp) => {
                            console.log("Success!" + resp.status);
                            this.isError = false;
                            this.comment.content = "";
                            this.comments = this.getComments();
                        })
                        .catch((err) => {
                            console.log(err.response.data);
                        })
                }
            },
            mounted() {
                this.getComments();
            }
        })
    </script>
</body>
</html>
