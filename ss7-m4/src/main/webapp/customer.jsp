<%--
  Created by IntelliJ IDEA.
  User: aquar
  Date: 2023/11/10
  Time: 8:14
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
        <th>Name</th>
        <th>Date of Birth</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${customerList}">
        <tr>
            <td>${c.name}</td>
            <td>${c.dob}</td>
            <td>${c.address}</td>
            <td><img src="${c.image}" alt="${c.name}'s Image" width="50" height="50"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
