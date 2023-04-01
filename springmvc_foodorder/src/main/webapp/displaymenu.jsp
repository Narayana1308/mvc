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
			<th>Menu id</th>
			<th>name</th>
			<th>Show menu</th>
			<th>Add food product</th>
			<th>delete</th>
			<th>update</th>
		</tr>
		<c:forEach var="menu" items="${list}">

			<tr>
				<td>${menu.id}</td>
				<td>${menu.name}</td>
				<td> <a href="showmenu?id=${menu.id}">show</a> </td>
				<td> <a href="addfoodproduct">add</a> </td>
				<td><a href="deletemenu?id=${menu.id}">Delete</a></td>
				<td><a href="updatemenu?id=${menu.id}">update</a></td>
			</tr>

		</c:forEach>




	</table>
<br><br>
	<a href="displayManager"> <button>save menu</button> </a><br><br>

	<a href="assignstaff"><button> assign staff</button> </a><br><br>
		<a href="home.jsp"><button>Home</button> </a>
</body>
</html>