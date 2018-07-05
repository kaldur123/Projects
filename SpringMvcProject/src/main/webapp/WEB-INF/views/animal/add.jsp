<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 06.05.2018
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <title>Add Animal</title>
</head>
<body>

    <div class="container">
        <h2 class="text-center">Add Animal to DB</h2>
        <form class="form-horizontal"
          action="${pageContext.request.contextPath}/animal/add" method="post">
        <div class="form-group">
            <label class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
                <input type="text" name="name">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Kind</label>
            <div class="col-sm-10">
                <input type="text" name="kind">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Gender</label>
            <div class="col-sm-10">
                <input type="text" name="gender">
            </div>
        </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">Sign in</button>
                </div>
            </div>
    </form>
        <a href="${rootURL}/animal/animals">List of animals</a>
    </div>
</body>
</html>
