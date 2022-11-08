<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Davidenko
  Date: 05.11.2022
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<html xmlns:th="http://www.thymeleaf.org"
      xmlns="http://www.w3.org/1999/html">

<head>
    <title>Hello</title>
</head>
<body>
<h1>All users:</h1>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="user" items="${allUsers}">
        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.department}</td>
            <td>${user.salary}</td>
            <td><input type="button" value="Update" onclick="window.location.href = 'addNewUser/?userId=${user.id}'">
            <input type="button" value="Delete" onclick="window.location.href = 'removeUser/?userId=${user.id}'"></td>
        </tr>

    </c:forEach>
    </thead>
</table>

<br>
<input type="button" value="Add user" onclick="window.location.href = 'addNewUser'"/>
</body>
</html>
