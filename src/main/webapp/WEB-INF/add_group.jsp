<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
        <td style="text-align: right">
            <form action="/logout" method="post" id="logoutForm">
                <input type="submit" value="Logout"/>
            </form>
        </td>
    </tr>
</table>
<hr/>
<form:form modelAttribute="group" action="/home/add" method="POST">
<table class="t1">
        <tr>
            <td><form:label path="number">Number:</form:label></td>
            <td><form:input path="number"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="facultity">Facultity:</form:label></td>
            <td><form:input path="facultity"></form:input></td>
        </tr>
        <tr>
            <td><input type="submit" name="save" value="Save"></td>
            <td><input type="button" value="Cancel" onClick='location.href="/home"'/></td>
        </tr>
</table>
</form:form>
</body>
</html>