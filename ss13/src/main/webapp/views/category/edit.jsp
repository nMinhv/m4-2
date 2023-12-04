<%--
  Created by IntelliJ IDEA.
  User: aquar
  Date: 2023/11/16
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
<form:form modelAttribute="category" method="post" action="/category/save-category">
    <form:input readonly="true" path="categoryId"/>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Category Name</label>
        <form:input path="categoryName" type="text" class="form-control" id="exampleInputEmail1"
                    aria-describedby="emailHelp"/>
    </div>
    <div class="form-check form-check-inline">
        <form:radiobutton path="status" class="form-check-input" value="0"/>
        <label class="form-check-label">Hide</label>
    </div>
    <div class="form-check form-check-inline">
        <form:radiobutton path="status" class="form-check-input" value="1"/>
        <label class="form-check-label">Show</label>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>
