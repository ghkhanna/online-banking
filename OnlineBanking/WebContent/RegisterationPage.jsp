<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<form action="RegisterationServlet" method="post">
	<table>
	<tr>
	<td>Account type:</td><td><input type="text" name="accountType"></td>
	</tr>
	<tr>
		<td>Generate new pin:</td><td><input type="text" name="pinNumber"></td>
	</tr>
	<tr>
		<td>Deposit Initial Amount:</td><td><input type="number" name="initialAccountBalance"></td>
	</tr>
	</table>
	<input type="submit" value="REGISTER">
	</form>
</div>
</body>
</html>