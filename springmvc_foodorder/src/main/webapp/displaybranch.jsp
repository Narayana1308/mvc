<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="2px Solid">

		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Delete</th>
			<th>Update</th>
			
			<th>Add Manager</th>
			<th>Manager Email id</th>
			
		</tr>

		<c:forEach var="branch" items="${list}">
			<tr>
				<td>${branch.id}</td>
				<td>${branch.name}</td>
				<td>${branch.address}</td>
				<td>${branch.email}</td>
				<td>${branch.phone}</td>
                <td> <a href="delete?id=${branch.id}">delete</a> </td>
                <td> <a href="update?id=${branch.id}">Update</a> </td>
                <td> <a href="addmanager?id=${branch.id}">ADD Manager</a> </td>
                
                
                <td>${branch.user.getEmail()}</td>
			</tr>


		</c:forEach>



	</table><br>
	<a href="branch"> <button> save branch</button> </a> <br><br>
	<a href="managers"> <button>show managers</button> </a><br><br>
	<a href="home.jsp"> <button>back</button> </a>
</body>
</html>