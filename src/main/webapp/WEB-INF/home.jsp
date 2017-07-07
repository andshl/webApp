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
<table style="width: 100%">
    <tr>
        <td><input type="button" value="Add" onClick='location.href="/home/add"'/></td>
        <td style="text-align: right">
            <form action="/logout" method="post" id="logoutForm">
                <input type="submit" value="Logout"/>
            </form>
        </td>
    </tr>
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
    <c:forEach items="${groups}" var="group">
        <tr style="text-align: center">
            <td><a href="/home/${group.number}">${group.number}</a></td>
            <td>${group.createdDate}</td>
            <td>${group.modifiedDate}</td>
            <td>
              <a href="/home/edit?id=${group.id}">Edit</a> / <a href="/home/delete?id=${group.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
