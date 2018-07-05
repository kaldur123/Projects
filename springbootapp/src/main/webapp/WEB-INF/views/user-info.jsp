<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 25.05.2018
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title>Title</title>
    <style>
        /*.user-row {*/
            /*margin-bottom: 14px;*/
        /*}*/

        /*.user-row:last-child {*/
            /*margin-bottom: 0;*/
        /*}*/

        /*.dropdown-user {*/
            /*margin: 13px 0;*/
            /*padding: 5px;*/
            /*height: 100%;*/
        /*}*/

        /*.dropdown-user:hover {*/
            /*cursor: pointer;*/
        /*}*/

        /*.table-user-information > tbody > tr {*/
            /*border-top: 1px solid rgb(221, 221, 221);*/
        /*}*/

        /*.table-user-information > tbody > tr:first-child {*/
            /*border-top: 0;*/
        /*}*/


        /*.table-user-information > tbody > tr > td {*/
            /*border-top: 0;*/
        /*}*/
        /*.toppad*/
        /*{margin-top:20px;*/
        /*}*/
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">${userInfo.firstName} ${userInfo.lastName}</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center">
                            <img alt="User Pic" src="data:image/png;base64, ${imgSrc}" width="300" height="310" class="img-circle img-responsive">
                        </div>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Email:</td>
                                    <td>${userInfo.email}</td>
                                </tr>
                                <tr>
                                    <td>Login:</td>
                                    <td>${userInfo.login}</td>
                                </tr>
                                <tr>
                                    <td>Salary:</td>
                                    <td>${userInfo.salary}</td>
                                </tr>
                                <tr>
                                    <td>Password:</td>
                                    <td>${userInfo.pass}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
