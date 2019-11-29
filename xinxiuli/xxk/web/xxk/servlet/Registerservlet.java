package web.xxk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Testutil.Myutil;
import dao.Myxxk;
import dao.imp.Myxxkimpl;
import dao.impl.AccountDaoImpl;
import db.DbHelp;
import dto.Returnmsg;
import net.sf.json.JSONObject;
import pojo.Account;
import util.GenericPrimaryKey;

public class Registerservlet extends HttpServlet{
    
	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
        doPost(req,resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	     resp.setHeader("Content-Type", "application/json,charset=utf-8");  
    	            PrintWriter out=resp.getWriter(); 
    	            
    	            String    ip      =Myutil.getRemoteHost(req);
    	            Connection  conn =DbHelp.getConnection();             
    	            Account  account = new Account();
    	            AccountDaoImpl  acountdao =new AccountDaoImpl(); 	       
    	            Myxxk aaccount=new Myxxkimpl();
    	            
    	           
                    
    	            
    	            String  rmsg = req.getParameter("rmsg"); 
    	         
    	       //  System.out.println(rmsg);  
    	         JSONObject object =JSONObject.fromObject(rmsg);
    	         //checkcode  
    	         String  checkcode   =object.getString("checkcode");
    	         String  phonevalue  =object.getString("phonevalue");
    	         String  pwd2value   =object.getString("pwd2value");
    	         
    	         //验证码
    	         String authcode =req.getSession().getAttribute("authcode").toString();
    	          if(authcode.equalsIgnoreCase(checkcode)){
    	        	try {
    	        		    conn.setAutoCommit(false);
				     boolean flag =aaccount.selectaccount(phonevalue, conn);
 				                  conn.commit();
				       // System.out.println(flag);
				       //账号存住
				       if(flag){
				          Returnmsg   msg1   =  new Returnmsg(1,"您的账号已存在");
		    	          JSONObject  ret1   =  JSONObject.fromObject(msg1);          	    
		    	          out.write(ret1.toString()); 
				          }
				     //账号存不住
				      if(!flag){  	 
	    	        	    account.setAccount_num(phonevalue);
	    	        	    account.setAccount_pass(pwd2value);
	    	        	    account.setCart_num(GenericPrimaryKey.getPrimaryKey());
	    	        	    account.setUsers_ip(ip);
	    	        //	    System.out.println(req.getRemoteAddr());
	    	        	             
	    	        	    acountdao.insertAccount(account, conn); 
    	    	        	         conn.commit();
	    	        	    //将注册信息存到session
    	    	        	         
	    	        	    req.getSession().setAttribute("account",account); 
	    	        	    
	    	        	    Returnmsg   msg0   =  new Returnmsg(0,"感谢您的注册");
	   		    	        JSONObject  ret0   =  JSONObject.fromObject(msg0);          	    
	   		    	        out.write(ret0.toString());
	
	    	        	     } 
					    } catch (Exception e) {
						// TODO Auto-generated catch block 
					    	try {
								conn.rollback();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					    	
						   e.printStackTrace();
						   
					   }finally {
						DbHelp.closeConnection(conn);           	
					}    
    	        	  
    	          }else { 
    	        	  
    	        	//验证码错误
    	            Returnmsg msg2 = new Returnmsg(2,"验证码错误，请重新输入");
    	            JSONObject   ret2  =JSONObject.fromObject(msg2);          	    
    	        	out.write(ret2.toString()); 
    	          }           
               //  System.out.println("test");
      }        
}