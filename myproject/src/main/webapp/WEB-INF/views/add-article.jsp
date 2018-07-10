<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 20.06.2018
  Time: 18:34
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
            font-family: 'Russo One', sans-serif;
        }
        body {
            background-image: url("http://res.cloudinary.com/hercules/image/upload/v1531147471/body/bg.jpg");
            background-attachment: fixed;
            background-size: cover;
        }
        table{
            margin: 0 auto;
        }
        td{
            padding: 10px;
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
            text-align: center;
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
        button{
            color: black;
            margin-left: 380px;
        }
        #editor{
            margin: 20px;
        }
        .article{
            color: black;
            margin: 20px 50px;
        }
        .error{
            font-size: 20px;
            color: red;
        }
        .one{
            color: snow;
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
    <form:form action="/user/add-article" method="post" modelAttribute="articleDto">
        <form:errors path="*" cssClass="error"/><br>
        <table>
            <tr>
                <td class="one">Title of article:</td>
                <td><form:input path="title"/></td>
            </tr>
            <tr>
                <td class="one">Choose dino:</td>
                <td><form:select path="dinoKind" id="category1" name="category1">
                    <form:option value="">Choose kind</form:option>
                    <form:options items="${kinds}"/>
                    </form:select></td>
            </tr>
            <tr>
                <td></td>
                <td><form:select path="dinoName" disabled="true" class="subcat" id="category2" name="category2">
                    <option value="">Choose name</option>
                    <c:forEach items="${kinds}" var="kind" varStatus="i">
                        <optgroup data-rel="${kind}">
                            <c:forEach items="${names[i.index]}" var="name">
                                <option value="${name}">${name}</option>
                            </c:forEach>
                        </optgroup>
                    </c:forEach>
                </form:select></td>
            </tr>
        </table>
        <div class="article"><textarea name="content" id="editor"></textarea></div>
        <button type="submit">Add</button>
    </form:form>
    </section>
</main>
    <script src="/resources/js/jquery.js"></script>
    <script src="/resources/js/ckeditor.js"></script>
    <script>
        ClassicEditor
            .create( document.querySelector( '#editor' ) )
            .then( editor => {
            console.log( editor );
        } )
        .catch( error => {
            console.log( error );
        });

        $(function(){

            var $cat = $("#category1"),
                $subcat = $(".subcat");

            var optgroups = {};

            $subcat.each(function(i,v){
                var $e = $(v);
                var _id = $e.attr("id");
                optgroups[_id] = {};
                $e.find("optgroup").each(function(){
                    var _r = $(this).data("rel");
                    $(this).find("option").addClass("is-dyn");
                    optgroups[_id][_r] = $(this).html();
                });
            });
            $subcat.find("optgroup").remove();

            var _lastRel;
            $cat.on("change",function(){
                var _rel = $(this).val();
                if(_lastRel === _rel) return true;
                _lastRel = _rel;
                $subcat.find("option").attr("style","");
                $subcat.val("");
                $subcat.find(".is-dyn").remove();
                if(!_rel) return $subcat.prop("disabled",true);
                $subcat.each(function(){
                    var $el = $(this);
                    var _id = $el.attr("id");
                    $el.append(optgroups[_id][_rel]);
                });
                $subcat.prop("disabled",false);
            });
        });
    </script>
</body>
</html>
