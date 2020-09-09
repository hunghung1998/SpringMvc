<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="utf-8">
<title>Helo Spring MVC + JDBC</title>
</head>
<body>
	<a href="<c:url value="/customer-list" />">List Customer</a><br />
	<h1>Edit Sectors:</h1>
	<c:url value="/updateCustomer" var="updateCustomer" />
	<form:form action="${updateCustomer}" method="POST" modelAttribute="sectors">
	
	<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Status</td>
		</tr>
		<tr>
			<td><form:input type="text" path="id" readonly="true" /> </td>
			<td><form:input path="name" /> </td>
			<td> <form:input path="status" /></td>
		</tr>
		<tr>
			<td colspan = "3"><button type="submit">Submit</button></td>
		</tr>
		<tr></tr>
	</table>
	</form:form>
</body>
</html>