<%--
  Created by IntelliJ IDEA.
  User: aquar
  Date: 2023/11/10
  Time: 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="calculator" method="post">
  Operand 1: <input type="text" name="operand1"><br>
  Operand 2: <input type="text" name="operand2"><br>
  Operator:
  <select name="operator">
    <option value="add">Add</option>
    <option value="subtract">Subtract</option>
    <option value="multiply">Multiply</option>
    <option value="divide">Divide</option>
  </select><br>
  <input type="submit" value="Calculate">
</form>
<c:if test="${not empty error}">
  <p style="color: red;">${error}</p>
</c:if>
</body>
</html>
