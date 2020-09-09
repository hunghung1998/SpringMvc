<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>Helo Spring MVC + JDBC</title>
<style>
table, th, td {
	border: 1px solid black;
}
td {
	padding-right: 30px;
}
</style>
</head>
<style><%@include file="/WEB-INF//css/style.css"%></style>
<body>
	<c:url value="/customer-save" var="urlSave"/>
	<c:url value="/customer-view/" var="urlView"/>
	<c:url value="/customer-update/" var="urlUpdate"/>
	<c:url value="/customerDelete/" var="urlDelete"/>
	<c:url value="/login/" var="urlLogin"/>
	<c:url value="/list-json" var="urlJson"></c:url>
	<c:url value="/list-items" var="urlJsonItems"></c:url>
	

	<div id="container">	
    <div id="menu">
		  <jsp:include page="menuchon.jsp"></jsp:include>
	</div>
	<div id="content">
		<div id="header">
		 	<h1>List Sectors:</h1>
			<a href="${urlLogin}">Login</a><br>
			<a href="${urlJson}">list-json-sectors</a> <br>
			<a href="${urlJsonItems}">list-json-items</a>
			<br>
		</div>
	 <a href="${urlSave}">Add Customer</a><br>
	 <table id="tablesector" border="1" cellpadding="5" cellspacing="1" >
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Status</th>
			<th>View</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:if test="${not empty listCustomer}">
			<c:forEach var="customer" items="${listCustomer}">
				<tr style="border: 1px black solid">
					<td>${customer.id}</td>
					<td>${customer.name}</td>
					<td>${customer.status}</td>
					 <td> <a href="${urlView}/${customer.id}">View</a></td>
					<td> <a href="${urlUpdate}/${customer.id}">Edit</a></td>
					<td> <a href="${urlDelete}/${customer.id}">Delete</a></td> 
				</tr>
			</c:forEach>
		</c:if>
	</table>
</div>
</div>
</body>
</html>