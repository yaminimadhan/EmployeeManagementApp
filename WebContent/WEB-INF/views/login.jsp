<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>Employee Management</title>
</head>
<body>
  <div align="center">
	<h1 style="margin-top:50px;">Employee Management</h1>
	<form method="get" action="getEmployees">
	<table border="0" cellpadding="20">
		<tr >
        	<td style="padding:10px">Username </td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
        	<td style="padding:10px">Password </td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
        	<td style="padding:10px"><input type="submit" value="Login" /></td>
        </tr>
    </table>
    </form>
  </div>
</body>
</html>