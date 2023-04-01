<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="userdetails" modelAttribute="user">
id <form:input path="id" readonly="true"/>
Name <form:input path="name"/> <br>
Email <form:input path="email" /> <br>
Password <form:input path="password"/> <br>
Phone <form:input path="phone"/> <br>

role <form:input path="role" readonly="true"/> <br>

<input type="submit">
</form:form>

</body>
</html>