<%--
  Created by IntelliJ IDEA.
  User: DragonFist
  Date: 15.06.2018
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <title>Title</title>
    <style type="text/css">
        .error{
            color: red;
            border-color: red;
        }
    </style>
</head>
<body>
<div id="app">
    <!--       {{message}}-->
    <div class="container">
        <div class="row">
            <label class="control-label" :class="{error: isError}" v-if="isError">This field is empty</label>
            Name: <input :class="{error: isError}" type="text" v-model="product.name"><br>
            Price: <input type="text" v-model="product.price"><br>
            Rating: <input type="text" v-model="product.rating"><br>
            Description: <input type="text" v-model="product.description"><br>
            <button @click="saveProduct()">Add product</button>

        </div>
        <br>
        <div class="row">
            <div class="col-md-12">
                <div v-for="product in products" class="col-md-4">
                    <div class="thumbnail">
                        <h4 class="text-center">
                            <span class="label label-info">{{product.name}}</span>
                        </h4>
                        <img :src="'http://placehold.it/650x450&text=' + product.name">
                        <div class="caption">
                            <div class="row">
                                <div class="col-md-6">
                                    <h4>
                                        <div v-for="star in 5" style="display: inline-block;">
                                            <span v-if="star <= product.rating" class="glyphicon glyphicon-star"></span>
                                            <span v-else class="glyphicon glyphicon-star-empty"></span>
                                        </div>
                                    </h4>
                                </div>
                                <div class="col-md-6">
                                    <h4>$ {{product.price}}</h4>
                                </div>
                            </div>
                        </div>
                        <p>{{product.description}}</p>
                        <div class="row text-center">
                            <div class="col-md-12">
                                <button @click="getProduct(product.id)" class="btn btn-info">Edit</button>
                                <button @click="deleteProduct(product.id)" class="btn btn-danger">Delete</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/resources/js/axios.min.js"></script>
<script src="/resources/js/vue.min.js"></script>
<script src="/resources/js/main.js"></script>
</body>
</html>
