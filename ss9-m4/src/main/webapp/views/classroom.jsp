<%--
  Created by IntelliJ IDEA.
  User: aquar
  Date: 2023/11/13
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach items="${list}" var="item">
        <li><a>${item.name}</a></li>
    </c:forEach>
</ul>

</body>
</html>
