package com.cg.banking.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.banking.beans.Account;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.AccountDAOImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public LoginServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accountNumber=Integer.parseInt(request.getParameter("accountNo"));
		int pinNumber=Integer.parseInt(request.getParameter("pinNumber"));
		AccountDAO accountDAO= new AccountDAOImpl();
		Account account = accountDAO.findOne(accountNumber);
		if(account!=null && account.getPinNumber()==pinNumber){
			HttpSession session = request.getSession();
			session.setAttribute("account", account);
			RequestDispatcher dispatcher= request.getRequestDispatcher("loginSuccessPage.jsp");
			dispatcher.forward(request, response);
		}
		else
			response.sendRedirect("HomePage.jsp");
	}

}


