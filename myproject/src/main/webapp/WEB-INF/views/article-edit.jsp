<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 04.07.2018
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
    <style>
        #editor{
            margin: 20px;
        }
        .article{
            margin: 20px 200px;
        }
    </style>
</head>
<body>
    <form:form action="/user/my-articles/${articleId}" method="post" modelAttribute="articleDto">
        <form:errors path="*" cssClass="error"/><br>
        Title: <form:input path="title"/>
        <%--<div class="article"><textarea name="content" id="editor">${content}</textarea></div>--%>
        <button type="submit">Edit</button>
    </form:form>
    <%--<script src="/resources/js/jquery.js"></script>--%>
    <%--<script src="/resources/js/ckeditor.js"></script>--%>
    <%--<script>--%>
        <%--ClassicEditor--%>
            <%--.create( document.querySelector( '#editor' ) )--%>
            <%--.then( editor => {--%>
                <%--console.log( editor );--%>
            <%--} )--%>
            <%--.catch( error => {--%>
                <%--console.log( error );--%>
            <%--});--%>
    <%--</script>--%>
</body>
</html>
