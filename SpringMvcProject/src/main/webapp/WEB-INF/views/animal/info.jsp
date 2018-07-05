<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 07.05.2018
  Time: 4:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="${rootURL}/resources/css/bootstrap.min.css">
    <title>Animal Info</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="span4 well">
                <div class="row">
                    <div class="span1">
                        <img src="http://www.clker.com/clipart-placeholder.html" alt="" width="100px">
                    </div>
                    <div class="span3">
                        <p><strong>${animalInfo.name}</strong> <strong>${animalInfo.kind}</strong></p>
                        <p> ${animalInfo.gender}</p>
                </div>
            </div>
        </div>
    </div>
    </div>
</body>
</html>
