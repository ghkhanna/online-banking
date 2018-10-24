<%@page session="false" %>
<%@page import="com.cg.banking.beans.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Successful</title>
</head>
<body>

<%
	HttpSession session= request.getSession();
	Account account= null;
	if(session==null)
		response.sendRedirect("HomePage.jsp");	
	else
		account=(Account)session.getAttribute("account");
%>


<div align="centre">
<font color="purple"> 
Choose Service:
<form action="LoginServicesServlet" method="post">
<input type="number" name="depositAmount">
<input type="submit" value="Deposit amount" name="deposit"><br>
<input type="number" name="withdrawAmount">
<input type="submit" value="Withdraw amount" name="withdraw">
<input type="submit" value="Fund Transfer" name="fundTransfer">
</form>
</div>
</body>
</html>