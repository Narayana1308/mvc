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

	<form:form action="updatedetails" modelAttribute="branch">

Branch  id<form:input path="id" readonly="true" />
		<br>
Branch NAME <form:input path="name" />
		<br>
Branch Address <form:input path="address"  />
		<br>

Branch Email <form:input path="email"  />
		<br>
Branch phone <form:input path="phone"  />
		<br>
  	User Email <form:input path="user.email"  readonly="true"/>
    <%-- user name <form:input path="user.name" /> 
    User Email <form:input path="user.email" />
     user password <form:input path="user.password" />
    user phone <form:input path="user.phone" />
    User role <input type="radio" name="user.role" value="Manager">manager  --%>


 
					
					
					<input type="submit">


	</form:form>

</body>
</html>