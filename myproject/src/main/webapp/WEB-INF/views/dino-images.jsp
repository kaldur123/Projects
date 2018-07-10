<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 09.07.2018
  Time: 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/includes/css-incl.jsp"%>
    <link href="https://fonts.googleapis.com/css?family=Russo+One" rel="stylesheet">
    <%--<link rel="stylesheet" href="/resources/css/gallery.css">--%>
    <style>
        *{
            margin: 0;
            padding: 0;
            text-align: center;
            font-family: 'Russo One', sans-serif;
        }
        body {
            margin: 0;
            padding: 0;
            font: 75%/120% Arial, Helvetica, sans-serif;
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

        h2 {
            font: bold 190%/100% Arial, Helvetica, sans-serif;
            margin: 0 0 .2em;
        }

        h2 em {
            font: normal 80%/100% Arial, Helvetica, sans-serif;
            /*color: #999999;*/
        }

        #largeImg {
            border: solid 1px #fff0;
            /*width: 550px;*/
            height: 400px;
            padding: 5px;
        }

        #thumbs a {
            border: solid 1px #fff0;
            width: 100px;
            height: 100px;
            padding: 3px;
            margin: 2px;
            float: left;
        }

        #thumbs a:hover {
            border-color: #FF9900;
        }

        #thumbs li {
            list-style: none;
        }

        #thumbs {
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
        }
        .st{
            background-color: #ffcf21;
        }
        .in{
            margin: 0 auto;
        }
        button{
            margin: 0 auto;
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
<div id="app">
    <p><img id="largeImg" height="300px"></p>

    <ul id="thumbs">
        <div class="st" v-for="image in images">
        <li>
            <a :href="image.image" title="Img"><img :src="image.image" width="92px" height="92px"></a>
        </li>
        </div>
    </ul>
    <br>
    <sec:authorize access="isAuthenticated()">
        <sec:authorize access="hasRole('USER')">
            <input type="file" @change="selectFile($event)" class="in">
            <input type="hidden" id="csrf" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div :class="{full: isFull}" v-if="isFull"><button @click="sendFile()" class="btn btn-info">Save image</button></div><br>
        </sec:authorize>
    </sec:authorize>
</div>
    <%@ include file="/WEB-INF/includes/js-incl.jsp" %>
    <script type="text/javascript">
        new Vue({
            el: "#app",
            data: {
                // rootUrl: "http://localhost:8080/rest",
                rootUrl: "https://fathomless-tor-42836.herokuapp.com/rest",
                file: "",
                images: [],
                dinoId: ${dinoId},
                isFull: false,
                csrf: ""
            },
            methods: {
                getImages() {
                    axios.get(this.rootUrl + "/articles/dino/" + this.dinoId)
                        .then((resp) => {
                            console.log("Success" + resp.data);
                            this.images = resp.data;
                        })
                        .catch((err) => {
                            console.log(err.response.data);
                        })
                },
                selectFile(event) {
                    console.log(event.target.files[0]);
                    this.file = event.target.files[0];
                    this.isFull = true;
                },
                sendFile() {
                    if ("${writerName}" != "") {
                        this.csrf = document.querySelector('#csrf').getAttribute("value");
                    }
                    if (this.file.name === "") return;

                    let formData = new FormData();
                    formData.append("${_csrf.parameterName}", this.csrf);
                    formData.append("file", this.file);


                    axios.post(this.rootUrl + "/articles/dino/" + this.dinoId, formData, { headers: {
                            'content-type': 'multipart/form-data',
                            // 'X-Requested-With': 'XMLHttpRequest',
                            // 'X-CSRFToken': document.querySelector('#csrf').getAttribute('value')
                        }})
                        .then((resp) => {
                            console.log("Success!" + resp.status);
                            console.log(this.userId);
                            this.isFull = false;
                            this.images = this.getImages();
                        })
                        .catch((err) => {
                            console.log(err.response.data);
                        })
                }
            },
            mounted() {
                this.getImages();
            }
        })
    </script>
    <script>
        var largeImg = document.getElementById('largeImg');

        var thumbs = document.getElementById('thumbs');

        thumbs.onclick = function(e) {
            var target = e.target;

            while (target != this) {

                if (target.nodeName == 'A') {
                    showThumbnail(target.href, target.title);
                    return false;
                }

                target = target.parentNode;
            }

        }

        function showThumbnail(href, title) {
            largeImg.src = href;
            largeImg.alt = title;
        }


        /* предзагрузка */
        var imgs = thumbs.getElementsByTagName('img');
        for (var i = 0; i < imgs.length; i++) {
            var url = imgs[i].parentNode.href;
            var img = document.createElement('img');
            img.src = url;
        }
    </script>
</body>
</html>
