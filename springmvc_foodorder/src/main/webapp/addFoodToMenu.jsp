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

<form:form action="add" modelAttribute="food">

Id <form:input path="id" readonly="true"/>
Name <form:input path="name" readonly="true"/>
Type <form:input path="type" readonly="true"/> 
Description <form:input path="description" readonly="true"/>

Price <form:input path="price" readonly="true"/>
Availability <form:input path="availability" readonly="true"/>

 menu id <form:input path="menu.id"/>
<input type ="submit"> 


</form:form>

</body>
</html>