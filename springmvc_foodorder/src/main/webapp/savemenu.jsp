<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save menu </title>
</head>
<body>

<form:form action="savemenu" modelAttribute="menu">
Name: <form:input path="name"/>


<input type="submit">


</form:form>

</body>
</html>