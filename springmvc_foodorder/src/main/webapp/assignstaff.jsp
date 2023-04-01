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

<form:form action="saveuser" modelAttribute="user">

Name <form:input path="name"/> <br>
Email <form:input path="email"/> <br>
Password <form:input path="password"/>
Phone <form:input path="phone"/>

Role
				<input type="radio" name="role" value="Staff">staff 
					
					
					<input type="submit">


</form:form>

</body>
</html>