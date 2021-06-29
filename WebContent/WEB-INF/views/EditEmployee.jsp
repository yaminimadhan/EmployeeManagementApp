<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>Edit Employee</title>
</head>
<body>
	<div align="center">
		<h1 style="margin-top: 50px;">Edit Employee</h1>
		<form method="get" action="/EmployeeManagementApp/editEmployee/${ecode}">
			<table border="0" cellpadding="5">
				<tr>
					<td style="padding: 10px">Name:</td>
					<td><input type="text" name="name" value="${ename}" /></td>
				</tr>
				<tr>
					<td style="padding: 10px">Location:</td>
					<td><input type="text" name="loc" value="${location}"/></td>
				</tr>
				<tr>
					<td style="padding: 10px">Email:</td>
					<td><input type="text" name="mail" value="${email}"/></td>
				</tr>
				<tr>
					<td style="padding: 10px">Date of Birth:</td>
					<td><input type="text" name="date" value="${dob}"/></td>
				</tr>
				<tr>
					<td style="padding: 10px"><input type="submit" value="EDIT" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>