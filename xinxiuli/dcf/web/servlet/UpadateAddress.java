package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Account;
import service.ShowMyAddrsService;
import serviceImpl.ShowMyAddrsServiceImpl;

public class UpadateAddress extends HttpServlet{
   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String index=request.getParameter("index");
	     Account account=(Account)request.getSession().getAttribute("account");
	     boolean flag=false;
		 if(account!=null&&index!=null) {
		 String account_num = account.getAccount_num();
		   if(account_num!=null) {
			   ShowMyAddrsService sms=new ShowMyAddrsServiceImpl();
			   flag=sms.UpdateDefulAddres(account_num, Integer.valueOf(index));
			   PrintWriter out=response.getWriter();
			   out.print(flag);
		   }
		 }
	}
}
