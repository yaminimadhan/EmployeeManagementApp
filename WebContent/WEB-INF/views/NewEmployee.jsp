<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>Flight Search</title>
</head>
<body>
  <div align="center">
	<h1 style="margin-top:50px;">Add Employee</h1>
	<form method="get" action="addEmployee">
	<table border="0" cellpadding="5">
		<tr>
        	<td style="padding:10px">Name: </td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
        	<td style="padding:10px">Location: </td>
            <td><input type="text" name="loc" /></td>
        </tr>
        <tr>
        	<td style="padding:10px">Email: </td>
            <td><input type="text" name="mail" /></td>
        </tr>
        <tr>
        	<td style="padding:10px">Date of Birth: </td>
            <td><input type="text" name="date" placeholder="yyyy-mm-dd" /></td>
        </tr>
        <tr>
        	<td style="padding:10px"><input type="submit" value="ADD" /></td>
        </tr>
    </table>
    </form>
  </div>
</body>
</html>