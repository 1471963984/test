package web.xxk.houtai.servlert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.imp.Administratordaoimp;
import serviceimp.Administractorserviceimp;

public class Admloginservlet  extends  HttpServlet{
      @Override
     public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doPost(req, resp);
    }
       @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	   // TODO Auto-generated method stub
    	   resp.setHeader("Content-Type","application/json,charset=utf-8");
    	   //resp.setHeader("Content-Type", "application/json,charset=utf-8");  
           PrintWriter out =resp.getWriter();
    	   String username =req.getParameter("username");
    	   String password =req.getParameter("userpwd");
    	   
    	   Administractorserviceimp  dao = new Administractorserviceimp(); 
    	   boolean flag=dao.admlogin(username, password);
    	   if(flag){
    	     resp.sendRedirect("/xinxiuli/houtaiyemian/adminIndex.jsp");     
    	   }else{
    		  
    		   req.setAttribute("parammy","1"); 
    		   req.getRequestDispatcher("/houtaiyemian/adminLogin.jsp").forward(req, resp);
    	   }
       
       }
}
