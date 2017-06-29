<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Home</title>
    <style>
        .t1 { width: 70%; border: 1px solid black; border-collapse: collapse }
        .t1 td, .t1 th { padding: 5px; border: 1px solid black }
    </style>
</head>
<body>
<table style="width: 100%">
    <tr>
        <td><span>Hello '${person.lastName}'!</span></td>
        <td style="text-align: right"></td>
    </tr>
</table>
<hr/>
<form action="/save/${student.id}" method="POST">
<table class="t1">
        <tr>
            <td>LastName:</td><td><input type='text' name='lastName' value='${student.lastName}'></td>
        </tr>
        <tr>
            <td>FirstName:</td><td><input type='text' name='firstName' value='${student.firstName}'></td>
        </tr>
        <tr>
        <td>SecondName:</td><td><input type='text' name='secondName' value='${student.secondName}'></td>
        </tr>
        <tr>
        <td>DateOfEnrollment:</td><td><input type='text' name='dateOfEnrollment' value='${student.dateOfEnrollment}'></td>
        </tr>
        <tr>
        <td><input type="submit" name="save" value="Save"></td>
        </tr>
</table>
</form>
</body>
</html>