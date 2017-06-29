<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Home</title>
    <style>
        .t1 { width: 100%; border: 1px solid black; border-collapse: collapse }
        .t1 td, .t1 th { padding: 5px; border: 1px solid black }
    </style>
</head>
<body>
<c:url value="/j_spring_security_logout" var="logoutUrl" />

<table style="width: 100%">
    <tbody>
    <tr>
        <td><span>Hello '${person.lastName}'!</span></td>
        <td style="text-align: right"></td>
    </tr>
    </tbody>
</table>

<hr/>

<table class="t1">
    <thead>
    <tr>
        <th>Name</th>
        <th>CreationDate</th>
        <th>ModificationDate</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.firstName} ${student.secondName} ${student.lastName}</td>
            <td>2017/06/16</td>
            <td>2017/06/16</td>
            <td>
              <a href="/edit/${student.id}">Edit</a> / <a href="/delete/${student.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
