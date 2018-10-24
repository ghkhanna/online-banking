package com.cg.banking.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.AccountDAOImpl;


@WebServlet("/RegisterationServlet")
public class RegisterationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterationServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	
	public void destroy() {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountType= request.getParameter("accountType");
		float accountBalance=Float.parseFloat(request.getParameter("initialAccountBalance"));
		int pinNumber=Integer.parseInt(request.getParameter("pinNumber"));
		Account account=new Account(pinNumber, accountType, accountBalance);
		AccountDAO accountDAO=new AccountDAOImpl();		
		accountDAO.save(account);
	}

}
