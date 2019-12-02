package web.xxk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Testutil.Myutil;
import dao.Myxxk;
import dao.imp.Myxxkimpl;
import db.DbHelp;
import dto.Returnmsg;
import net.sf.json.JSONObject;
import pojo.Account;
import pojo.Users;

public class Loginservlet extends HttpServlet {
        
	   @Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
          doPost(req, resp);
	}
	

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setHeader("Content-Type", "application/json,charset=utf-8");  
                  PrintWriter out=resp.getWriter(); 
                  Myxxk dao=new  Myxxkimpl();       
                  Connection conn =DbHelp.getConnection();
                  boolean flag=false;
                  
                  Account  account = null;
                  
		          String  rmsg = req.getParameter("rmsg");
		          
		          
		          System.out.println(rmsg);
		          
		          JSONObject object=JSONObject.fromObject(rmsg);
		          String   username   =object.getString("username");
		          String   password   =object.getString("password");
       		     
       		      
		          try {
					   flag	=dao.selectaccount(username, conn);
					   
					  //查有没有这个账号 
					 if(flag){
					 Boolean flag1=dao.selectaccountinfo(username, password, conn);   
					  //查密码是否正确
					 if(flag1){
						     account =dao.selectAccountwhole(username,conn); 
						     if(account!=null){
						    	 
						        //记住密码 
//                             if(check!=null&&"true".equals(check)){
//                                 int expiry=60800;	 
//				              Cookie  ccookname=new Cookie("username",username);             
//						         ccookname.setMaxAge(expiry);
//						         ccookname.setPath("/");
//						         ccookname.setDomain("localhost");
//						         resp.addCookie(ccookname);
//						      Cookie  cookpass=new Cookie("password", password);
//						        cookpass.setMaxAge(expiry);
//						        cookpass.setPath("/");
//						        cookpass.setDomain("localhost");
//						        resp.addCookie(cookpass);
//						        System.out.println("记住密码"); 
//						        
//                             }
//                             
//                             //不记住密码
//                           if(check!=null&&"false".equals(check)){
//                        	     int expiry=0;
//                        	   Cookie  ccookname=new Cookie("username",username);             
//						         ccookname.setMaxAge(expiry);
//						       Cookie  cookpass=new Cookie("password", password);
//						         cookpass.setMaxAge(expiry);
//						         System.out.println("不记住密码");
//                             }
                             
						    	 
                             req.getSession().setAttribute("account",account);
 
                             Users user =dao.selectUsers(username, conn);
                             //增加
                             req.getSession().setAttribute("user",user);
						     Returnmsg   msg0   =  new Returnmsg(0,"您登录成功");
				    	     JSONObject  ret0   =  JSONObject.fromObject(msg0);          	    
				             out.write(ret0.toString()); 
                            } 
					      }else{
					    	  
					    	   //密码输入错误
					    	    Returnmsg   msg2   =  new Returnmsg(2,"您的密码输入错误");
				    	        JSONObject  ret2   =  JSONObject.fromObject(msg2);          	    
				    	        out.write(ret2.toString());    
					         }     	 
					   }else{
						 //账号错误
					     Returnmsg   msg1   =  new Returnmsg(1,"您的账号不存在");
		    	         JSONObject  ret1   =  JSONObject.fromObject(msg1);          	    
		    	         out.write(ret1.toString());  
					    }  
					 } catch (Exception e){
								// TODO Auto-generated catch block
								e.printStackTrace();
								try {
									conn.rollback();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						
				}finally{
					 DbHelp.closeConnection(conn);
				}
		       // System.out.println("0k"); 
	  }  
}
