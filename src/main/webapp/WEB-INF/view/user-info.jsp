<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<%--
  Created by IntelliJ IDEA.
  User: Davidenko
  Date: 05.11.2022
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User info</title>
</head>
<body>

<h1><p><a href="/PP_CRUD_war_exploded">User Info</a></p></h1>
<form:form action="saveUser" modelAttribute="user">
<form:hidden path="id"/>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>
    <td><form:input path="name"/></td>
    <br><br>
    <td>
      <form:input path="surname"/></td>
    <br><br>
    <td>
            <form:input path="department"/>
    </td><br><br>
    <td>
            <form:input path="salary"/>
    </td><br><br>
    <td><input type="submit" value="OK"/>
    </td>
      </form:form>

</body>
</html>
