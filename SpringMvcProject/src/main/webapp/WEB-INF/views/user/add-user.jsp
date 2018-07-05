<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 08.05.2018
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <title>Add User</title>
</head>
<body>
    <form:form action="${rootURL}/user/add" method="post" modelAttribute="user">
        Full Name <form:input path="fullName"/><br>
        Age     <form:input path="age" type="number"/><br>
        Country <form:select path="country">
                <form:options items="${countryList}"/>
                </form:select><br>
        Gender  <form:radiobuttons path="gender" items="${gender}"/><br>
        Email   <form:input path="email" type="email"/><br>
        Degree  <c:forEach items="${degrees}" var="degree">
                <form:radiobutton path="degree" value="${degree}"/>${degree}
                </c:forEach><br>
        Social Networks <form:checkboxes path="socNet" items="${networks}"/><br>
        Favorite Programming Language <form:radiobuttons path="favoriteProgrammingLanguage" items="${progList}"/><br>
        Operation Systems <form:checkboxes path="os" items="${os}"/><br>
        Programming Experience <form:input path="programmingExperience"/><br>
        Rank    <form:select path="rank">
                <form:options items="${ranks}"/>
                </form:select><br>
        Technologies <form:checkboxes path="technologies" items="${technologies}"/><br>
        Information Source <form:input path="informationSource"/><br>
        <button type="submit" class="btn-lg btn-primary">Add user</button>
    </form:form>
</body>
</html>
