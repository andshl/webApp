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
    <tbody>
    <tr>
        <td><span>Hello '${person.lastName}'!</span></td>
        <td style="text-align: right"><a href="/logout">Logout</a></td>
    </tr>
    </tbody>
</table>

<hr/>

<table class="t1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Creation Date</th>
        <th>Modification Date</th>
        <th>Actions</th>
    </tr>
    </thead>
    <%--TODO: fill rows dynamically--%>
    <tbody>
    <tr>
        <td>Entity 1</td>
        <td>2017/06/16</td>
        <td>2017/06/16</td>
        <td>
            <a href="/edit">Edit</a> / <a href="/delete">Delete</a>
        </td>
    </tr>
    <tr>
        <td>Entity 2</td>
        <td>2017/06/16</td>
        <td>2017/06/16</td>
        <td>
            <a href="/edit">Edit</a> / <a href="/delete">Delete</a>
        </td>
    </tr>
    </tbody>
</table>

</body>
</html>
