<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 19.06.2018
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
    <%--<meta name="csrf-token" content="${_csrf.token}">--%>
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
        .inf{
            margin: 0 auto;
            width: 600px;
        }
        .well{
            background-color: #b39a41;
            height: 270px;
        }
    </style>
</head>
<body>
<div id="app">
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
    <div class="row">
        <div class="inf">
            <div class="well well-sm">
                <div class="row">
                    <div class="col-sm-4 col-md-4">
                        Image: <img :src="imgUrl" alt="" width="200px" class="img-rounded img-responsive"><br>
                        <input type="file" @change="selectFile($event)">
                        <input type="hidden" id="csrf" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <br><div :class="{full: isFull}" v-if="isFull"><button @click="sendFile()" class="btn btn-success">Change avatar</button></div><br>
                    </div>
                    <div class="col-sm-6 col-md-8">
                        <h3>${user.fullName}</h3>
                        <h5>Age: ${user.age}</h5><br>
                        <small><cite>${user.country}<i class="glyphicon glyphicon-map-marker"></i></cite></small>
                        <p><br><i class="glyphicon glyphicon-envelope"></i> ${user.email}</p>
                    </div>
        <sec:authorize access="hasRole('ADMIN')">
            <form:form action="/admin/users/info/${userId}/delete" method="post" modelAttribute="user">
                <button type="submit">Delete</button>
            </form:form>
        </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</div>
        <%@ include file="/WEB-INF/includes/js-incl.jsp" %>
        <script type="text/javascript">
            new Vue({
                el: "#app",
                data: {
                    // rootUrl: "http://localhost:8080/rest",
                    rootUrl: "https://fathomless-tor-42836.herokuapp.com/rest",
                    file: "",
                    isFull: false,
                    userId: ${user.id},
                    imgUrl: "${user.imageUrl}",
                    csrf: document.querySelector('#csrf').getAttribute('value')
                },
                methods: {
                    selectFile(event) {
                        console.log(event.target.files[0]);
                        this.file = event.target.files[0];
                        if (this.file != "") {
                            this.isFull = true;
                        }
                        else {
                            this.isFull = false;
                        }
                    },
                    sendFile() {
                        if (this.file.name === "") return;

                        let formData = new FormData();
                        formData.append("${_csrf.parameterName}", this.csrf);
                        formData.append("file", this.file);


                        axios.post(this.rootUrl + "/load-image/" + this.userId, formData, { headers: {
                                'content-type': 'multipart/form-data',
                                // 'X-Requested-With': 'XMLHttpRequest',
                                // 'X-CSRFToken': document.querySelector('#csrf').getAttribute('value')
                            }})
                            .then((resp) => {
                                console.log("Success!" + resp.status);
                                console.log(this.userId);
                                this.file = "";
                                this.isFull = false;
                                this.imgUrl = resp.data;
                            })
                            .catch((err) => {
                                console.log(err.response.data);
                            })
                    }
                }
            })
        </script>
</body>
</html>
