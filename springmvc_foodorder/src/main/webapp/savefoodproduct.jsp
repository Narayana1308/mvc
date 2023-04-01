<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="savefoodproduct" modelAttribute="food">



Name<form:input path="name" /> <br><br>
type<form:input path="type" /> <br><br>
price<form:input path="price" /> <br><br>
description<form:input path="description" /> <br><br>

availability<form:input path="availability" /> <br><br>
 

 






<input type="submit">




</form:form>

</body>
</html>