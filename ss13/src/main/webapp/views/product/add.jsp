<%--
  Created by IntelliJ IDEA.
  User: aquar
  Date: 2023/11/16
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="product" method="post" action="/product/save-product" enctype="multipart/form-data">
    <div class="mb-3">
        <label for="productName" class="form-label">Product Name</label>
        <form:input path="productName" type="text" class="form-control" id="productName" aria-describedby="emailHelp"/>
    </div>
    <div class="mb-3">
        <label for="price" class="form-label">Price</label>
        <form:input path="price" type="number" class="form-control" id="price" aria-describedby="emailHelp"/>
    </div>
    <div class="mb-3">
        <label for="image" class="form-label">Image URL</label>
        <input name="img" type="file" class="form-control" id="image" aria-describedby="emailHelp"/>
    </div>
    <div class="mb-3">
        <form:select path="category.categoryId">
            <form:options items="${categories}" itemValue="categoryId" itemLabel="categoryName"/>
        </form:select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</body>
</html>