package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Account;
import service.DcfSAddAddresService;
import service.Impl.DcfAddAddresServiceImpl;

public class DeleAddress extends HttpServlet{
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	this.doPost(req, resp);
    }
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   String index=request.getParameter("addrindex");
    	   Account acc=(Account)request.getSession().getAttribute("account");
    	   if(index!=null) {    		  
    		   if(acc.getAccount_num()!=null) {   		
    			   DcfSAddAddresService asas=new DcfAddAddresServiceImpl();
    			   boolean b=asas.deleAddres(acc.getAccount_num(), Integer.parseInt(index));
    			   PrintWriter out=response.getWriter();
    			   out.print(b);
    		   }   
    	   }
    }
}
