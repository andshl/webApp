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
<form:form modelAttribute="student" action="/home/${number}/add" method="POST">
<table class="t1">
        <tr>
            <td><form:label path="lastName">LastName:</form:label></td>
            <td><form:input path="lastName"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="firstName">FirstName:</form:label></td>
            <td><form:input path="firstName"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="secondName">SecondName:</form:label></td>
            <td><form:input path="secondName"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="dateOfEnrollment">DateOfEnrollment:</form:label></td>
            <td><form:input path="dateOfEnrollment"></form:input></td>
        </tr>
        <tr>
            <td><input type="submit" name="save" value="Save"></td>
            <td><input type="button" value="Cancel" onClick='location.href="/home/${number}"'/></td>
        </tr>
</table>
</form:form>
</body>
</html>