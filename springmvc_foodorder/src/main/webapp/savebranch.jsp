<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form:form action="savebranch" modelAttribute="branch">

Branch Name: <form:input path="name"/>
Address : <form:input path="address"/>
Email : <form:input path="email"/>
phone : <form:input path="phone"/>

<input type="submit">

</form:form>

</body>
</html>