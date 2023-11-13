<%--
  Created by IntelliJ IDEA.
  User: aquar
  Date: 2023/11/10
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">

        <h1>Customer List</h1>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Sex</th>
                <th>Action</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${list}">
                <tr>
                    <td>${student.studentCode}</td>
                    <td>${student.studentName}</td>
                    <td>${student.age}</td>
                    <td>${student.sex}</td>
                    <td>
                        <a class="btn btn-danger" href="students?action=delete&id=${student.studentCode}" methods="post">Xóa</a>
                        <a class="btn btn-success" href="students?action=edit&id=${student.studentCode}">Sửa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-primary" href="views/student-add.jsp">Them moi sinh vien</a>
    </div>

</div>
</body>
</html>
