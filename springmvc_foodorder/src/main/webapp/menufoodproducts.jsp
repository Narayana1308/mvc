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
<th> name</th>
<th>type</th>
<th>description</th>
<th>price</th>
<th>availability</th>
<th>Delete</th>
<th>update</th>

</tr>

<c:forEach var="menu" items="${list}">

<tr>
<td>${menu.id}</td>
<td>${menu.name}</td>
<td>${menu.type}</td>
<td>${menu.description}</td>
<td>${menu.price}</td>
<td>${menu.availability}</td>
<td> <a href="deletefood?id=${menu.id}">Delete</a> </td>
<td> <a href="updatefood?id=${menu.id}">Update</a> </td>

</tr>


</c:forEach>
 	



</table>
<br><br>

<a href="menupage"><button> Back</button> </a>

</body>
</html>