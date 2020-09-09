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
	<a href="<c:url value="/customer-list" />" >List Customer</a><br />

	<h1>Add new Customer:</h1>
	<c:url value="/saveCustomer" var="saveCustomer"/>
	<form:form action="${saveCustomer}" method="POST" modelAttribute="customer">
		Id: <form:input path="id" /> <br/> <br/>
    	Name: <form:input path="name" /> <br/> <br/>
    	Image: <form:input type="file" path="image" /> <br/> <br/>
    	Status: <form:input path="status" /> <br/> <br/>
		<button type="submit">Submit</button>
	</form:form>

</body>
</html>
