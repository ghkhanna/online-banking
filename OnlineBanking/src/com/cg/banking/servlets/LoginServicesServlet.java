package com.cg.banking.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.AccountDAOImpl;


@WebServlet("/LoginServicesServlet")
public class LoginServicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServicesServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);		
			if(session!=null){
				AccountDAO accountDAO=new AccountDAOImpl();
				Account account= (Account)session.getAttribute("account");
				if (request.getParameter("deposit")!=null){
					account.setAccountBalance(account.getAccountBalance()+Integer.parseInt(request.getParameter("depositAmount")));
					((Transaction) account.getTransaction()).setTransactionType("Deposit");
					accountDAO.update(account);
					session.setAttribute("account", account);
					RequestDispatcher dispatcher= request.getRequestDispatcher("LoginSuccessPage.jsp");
					dispatcher.forward(request, response);
					
				}
				else if (request.getParameter("withdraw")!=null){
					float amount=Float.parseFloat(request.getParameter("withdrawAmount"));
					if (account.getAccountBalance()>=amount){
						account.setAccountBalance(account.getAccountBalance()-amount);
						((Transaction) account.getTransaction()).setTransactionType("Withdraw");
						accountDAO.update(account);
						session.setAttribute("account", account);
						RequestDispatcher dispatcher= request.getRequestDispatcher("LoginSuccessPage.jsp");
						dispatcher.forward(request, response);
					}
					else{}
						
				}
				else if (request.getParameter("fundTransfer")!=null){
					session.setAttribute("account", account);
					RequestDispatcher dispatcher= request.getRequestDispatcher("FundTransferDetailsPage.jsp");
					dispatcher.forward(request, response);
				}
				
			}
		
	}

}
