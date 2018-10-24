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
@WebServlet("/FundTransferServlet")
public class FundTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public FundTransferServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	
	public void destroy() {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);	
		if(session!=null){
			Account account= (Account)session.getAttribute("account");
			AccountDAO accountDAO=new AccountDAOImpl();
			int transferAccountNumber=Integer.parseInt(request.getParameter("transferAccountNumber"));
			float transferAmount=Float.parseFloat(request.getParameter("transferAmount")) ;
			Account account2 = accountDAO.findOne(transferAccountNumber);
			
			if ((account.getAccountBalance()>=transferAmount)&& (account2!=null)){
				account.setAccountBalance(account.getAccountBalance()-transferAmount);
				((Transaction) account.getTransaction()).setTransactionType("Withdraw");
				accountDAO.update(account);
				
				account2.setAccountBalance(account2.getAccountBalance()+transferAmount);
				((Transaction) account2.getTransaction()).setTransactionType("Deposit");
				accountDAO.update(account2);
				
				session.setAttribute("account", account);
				RequestDispatcher dispatcher= request.getRequestDispatcher("LoginSuccessPage.jsp");
				dispatcher.forward(request, response);
			}
		}
		
	}

}
