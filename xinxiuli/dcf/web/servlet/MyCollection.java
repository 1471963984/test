package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Account;
import service.DcfService;
import service.Impl.DcfServiceImpl;

public class MyCollection extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	this.doPost(req, resp);
    }
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          Account acc=(Account)request.getSession().getAttribute("account");
    	  String goodsid=request.getParameter("gid");
    	  String remo=request.getParameter("remove");
    	  DcfService ds=new DcfServiceImpl();
//    	  添加收藏
    	  if(goodsid!=null) { 
        	  boolean b=ds.addColl(acc.getAccount_num(), goodsid);
        	  PrintWriter out=response.getWriter();
        	  if(b) {
        		  out.print(b);
        	  }
    	  }
    	//取消收藏
    	  if(goodsid!=null&&remo!=null) {
    		boolean c=ds.deleterColl(acc.getAccount_num(), goodsid);
    		PrintWriter out=response.getWriter();
	      	  if(c) {
	      		  out.print(c);
	      	  }
    	  } 	  
    }
}
