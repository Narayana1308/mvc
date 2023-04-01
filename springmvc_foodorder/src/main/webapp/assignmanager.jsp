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
	<form:form action="manager" modelAttribute="branch">

Branch  id<form:input path="id" readonly="true" />
		<br>
Branch NAME <form:input path="name" readonly="true" />
		<br>
Branch Address <form:input path="address" readonly="true" />
		<br>

Branch Email <form:input path="email" readonly="true" />
		<br>
Branch phone <form:input path="phone" readonly="true" />
		<br>
  	
    user name <form:input path="user.name" /> 
    User Email <form:input path="user.email" />
    user password <form:input path="user.password" />
    user phone <form:input path="user.phone" />
    User role <input type="radio" name="user.role" value="Manager">manager 


 
					
					
					<input type="submit">


	</form:form>

</body>
</html>