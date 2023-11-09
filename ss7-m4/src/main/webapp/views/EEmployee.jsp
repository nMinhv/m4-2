<%--
  Created by IntelliJ IDEA.
  User: aquar
  Date: 2023/11/08
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<div class="row">
    <div class="col-lg-6">
<h1 class="text-center text-danger">edit nhân viên</h1>
<form action="<%=request.getContextPath()%>/nhan-vien" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">Mã Nhân viên</label>
        <input type="text" class="form-control" value="${employee.employeeId}" id="exampleInputEmail1" readonly name="employeeCode">
    </div>
    <div class="form-group">
        <label for="fullName">Họ Và Tên </label>
        <input type="text" class="form-control" value="${employee.fullName}" id="fullName" name="fullName">
    </div>
    <div class="form-group">
        <label for="age">Tuổi </label>
        <input type="text" class="form-control" id="age" value="${employee.age}" name="age">
    </div>
    <div class="form-group">
        <label for="salary">Lương c bản </label>
        <input type="text" class="form-control" id="salary" value="${employee.salary}" name="salary">
    </div>
    <input type="hidden" name="action" value="update">
    <button type="submit" class="btn btn-primary">Update</button>
</form>
    </div>
    </div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
