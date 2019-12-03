package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Account;
import service.DcfAdminUpdataStatusService;
import service.Impl.DcfAdminUpdataStatusServiceImpl;

public class AdminDeliver extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
    	   String status=reqest.getParameter("sta");
    	   String accnum=reqest.getParameter("accnum");
    
    	   if(status!=null&&accnum!=null) {
    		    DcfAdminUpdataStatusService dauss=new DcfAdminUpdataStatusServiceImpl();
    		    boolean b=dauss.adminUpdataStus(accnum, Integer.valueOf(status));
    		    PrintWriter out=response.getWriter();
    		    out.print(b);
    	   }
    }
}
