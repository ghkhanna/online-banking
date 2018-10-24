<%@page session="false" %>
<%@page import="com.cg.banking.beans.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

<div align="center">
<form action="FundTransferServlet" method="post">
	<table>
	<tr>
		<td>Transfer to Account (Account Number):</td>
		<td><input type="number" name="transferAccountNumber"></td>
	</tr>
	<tr>
		<td>Transfer Amount:</td>
		<td><input type="number" name="transferAmount"></td>
	</tr>
	</table>
</form>
</div>
</body>
</html>