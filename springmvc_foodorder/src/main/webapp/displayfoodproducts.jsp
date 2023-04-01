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
<th>menu id</th>
<th>add to menu</th>

</tr>

<c:forEach var="menufood" items="${list}">

<tr>
<td>${menufood.id}</td>
<td>${menufood.name}</td>
<td>${menufood.type}</td>
<td>${menufood.description}</td>
<td>${menufood.price}</td>
<td>${menufood.availability}</td>
<td>${menufood.menu.getId()}</td>
<td> <a href="addtomenu?id=${menufood.id}">add</a> </td>


</tr>


</c:forEach>




</table>
<c:out value="lkjkhgffxdcz"></c:out>
<a href="menupage"> <button>Back</button> </a>

</body>
</html>