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

	<table border="2px">

		<tr>
			<th>id</th>
			<th>name</th>
			<th>email</th>
			<th>Password</th>
			<th>phone</th>
			<th>role</th>
			
			<th>delete</th>
			<th>update</th>
			

		</tr>

		<c:forEach var="manager" items="${list}">

			<tr>
				<td>${manager.id}</td>
				<td>${manager.name}</td>
				<td>${manager.email}</td>
				<td>${manager.password}</td>

				<td>${manager.phone}</td>
				<td>${manager.role}</td>
				<td> <a href="deletemanager?id=${manager.id}"> delete</a></td>
			    <td> <a href="updatemanager?id=${manager.id}">update</a></td>

			</tr>


		</c:forEach>


</table>
<br><br>
<a href="displaybranch"> <button> back</button> </a>



</body>
</html>