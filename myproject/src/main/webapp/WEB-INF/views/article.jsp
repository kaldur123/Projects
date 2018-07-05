<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 26.06.2018
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
<html>
<head>
    <%--<meta name="csrf-token" content="${_csrf.token}">--%>
    <title>Title</title>
    <style>
        .error{
            color: red;
            border-color: red;
        }
    </style>
</head>
<body>
    <div id="app">
        ${article.title}<br>
        ${article.description}<br>
        <br>
        <br>
        <br>
            <sec:authorize access="hasRole('ADMIN')">
                <form:form action="/articles/${article.id}/delete" method="post" modelAttribute="article">
                    <button type="submit">Delete</button>
                </form:form>
            </sec:authorize>
            <sec:authorize access="hasRole('USER')">
                <c:choose>
                    <c:when test="${testId == article.writer.id}">
                        <form:form action="/articles/${article.id}/delete" method="post" modelAttribute="article">
                            <button type="submit">Delete</button>
                        </form:form>
                    </c:when>
                </c:choose>
            </sec:authorize>
        <h2>Comments</h2>
        <div v-for="comment in comments">
            <h3>{{comment.writerName}}</h3>
            <p>{{comment.text}}</p>
        </div>
        Add you comment:
            <sec:authorize access="isAuthenticated()">
                <input type="text" :class="{error: isError}" name="text" v-model="comment.content"/>
                <input type="hidden" id="csrf" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button @click="saveComment()" type="submit">Add comment</button>
                <label class="control-label" :class="{error: isError}" v-if="isError">This field is empty</label>
            </sec:authorize>
           <sec:authorize access="!isAuthenticated()">
               <a href="/login">Login</a>
           </sec:authorize>
    </div>
    <%@ include file="/WEB-INF/includes/js-incl.jsp"%>
    <script type="text/javascript">
        new Vue({
            el: "#app",
            data: {
                rootUrl: "http://localhost:8080/rest",
                comments: [],
                comment: {
                    content: "",
                    writerName: "${writerName}"
                },
                isError: false,
                csrf: ""
            },
            methods: {
                getComments() {
                    axios.get(this.rootUrl + "/articles/" + ${article.id})
                        .then((resp) => {
                            console.log("Success" + resp.data);
                            this.comments = resp.data;
                        })
                        .catch((err) => {
                            console.log(err.response.data);
                        })
                },
                saveComment() {
                    // this.comment = document.getElementsByName("text").valueOf();
                    if ("${writerName}" != "") {
                        this.csrf = document.querySelector('#csrf').getAttribute("value");
                    }
                    if (this.comment.content === "") {
                        this.isError = true;
                        return;
                    }

                    let formData = new FormData();
                    formData.append("${_csrf.parameterName}", this.csrf);
                    formData.append("text", this.comment.content);

                    axios.post(this.rootUrl + "/articles/" + ${article.id} + "/save-comment", formData)
                        .then((resp) => {
                            console.log("Success!" + resp.status);
                            this.isError = false;
                            this.comment.content = "";
                            this.comments = this.getComments();
                        })
                        .catch((err) => {
                            console.log(err.response.data);
                        })
                }
            },
            mounted() {
                this.getComments();
            }
        })
    </script>
</body>
</html>
