<%--
  Created by IntelliJ IDEA.
  User: aquar
  Date: 2023/11/15
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/account/storage" method="post" modelAttribute="account">
    <label for="name">Username</label>
    <form:input type="text" id="name" path="userName"/>
    <label for="name">Password</label>
    <form:input type="text" id="password" path="password"/>
    <button type="submit">ADD</button>

</form:form>
</body>
</html>
