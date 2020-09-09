<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>Helo Spring MVC + JDBC</title>
</head>

<body>
	  <a href="<c:url value="/customer-list" />" >List Sectors</a><br />
	<h1>View Sectors:</h1>	
	
	<table border="1" cellpadding="5" cellspacing="1" >
		<tr>
			<td>Sectors ID</td>
			<td>Sectors Name</td>
			<td>Sectors Image</td>
			<td>Sectors Address</td>
		</tr>
		<tr>
			<td>${customer.id}</td>
			<td>${customer.name}</td>
			<td><img src="data:image/jpeg;base64,${customer.image}" width="200" height="200"/></td>
			<td>${customer.status}</td>
		</tr>
	</table>
	<a href="<c:url value="/customer-list" />" >List Customer</a><br />
</body>
</html>