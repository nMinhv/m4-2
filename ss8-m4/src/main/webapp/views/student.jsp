<%--
  Created by IntelliJ IDEA.
  User: aquar
  Date: 2023/11/10
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customer List</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Sex</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${list}">
        <tr>
            <td>${student.studentCode}</td>
            <td>${student.studentName}</td>
            <td>${student.age}</td>
            <td>${student.sex}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
