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
    <style>
        #editor{
            margin: 20px;
        }
        .article{
            margin: 20px 200px;
        }
        .error{
            color: red;
        }
    </style>
</head>
<body>
    <form:form action="/user/add-article" method="post" modelAttribute="articleDto">
        <form:errors path="*" cssClass="error"/><br>
        Title of article: <form:input path="title"/><br>
        Choose dino: <form:select path="dinoKind" id="category1" name="category1">
        <form:option value="">Choose kind</form:option>
        <form:options items="${kinds}"/>
    </form:select><br>
        <form:select path="dinoName" disabled="true" class="subcat" id="category2" name="category2">
            <option value="">Choose name</option>
            <c:forEach items="${kinds}" var="kind" varStatus="i">
                <optgroup data-rel="${kind}">
                    <c:forEach items="${names[i.index]}" var="name">
                        <option value="${name}">${name}</option>
                    </c:forEach>
                </optgroup>
            </c:forEach>
        </form:select><br>
        <div class="article"><textarea name="content" id="editor"></textarea></div>
        <button type="submit">Add</button>
    </form:form>
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
