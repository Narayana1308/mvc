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

<form:form action="updateMenuDetails" modelAttribute="menu" >
Id <form:input path="id"  readonly="true"/>
NAME <form:input path="name"/>


<input type="submit">


</form:form>


</body>
</html>