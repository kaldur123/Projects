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
</head>
<body>
<div id="app">
        Full Name: ${user.fullName}<br>
        Age: ${user.age}<br>
        Email: ${user.email}<br>
        Country: ${user.country}<br>
        Image: <img :src="imgUrl" alt="" width="200px"><br>
        <input type="file" @change="selectFile($event)">
        <input type="hidden" id="csrf" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div :class="{full: isFull}" v-if="isFull"><button @click="sendFile()" class="btn btn-info">Change avatar</button></div><br>
        <sec:authorize access="hasRole('USER')">
            <a href="/user">To profile page</a>
        </sec:authorize>
        <sec:authorize access="hasRole('ADMIN')">
            <a href="/admin">To profile page</a>
            <form:form action="/admin/users/info/${userId}/delete" method="post" modelAttribute="user">
                <button type="submit">Delete</button>
            </form:form>
        </sec:authorize>
</div>
        <%@ include file="/WEB-INF/includes/js-incl.jsp" %>
        <script type="text/javascript">
            new Vue({
                el: "#app",
                data: {
                    rootUrl: "http://localhost:8080/rest",
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
                        this.isFull = true;
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
