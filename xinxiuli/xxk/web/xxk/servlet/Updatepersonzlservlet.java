package web.xxk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Myxxk;
import dao.imp.Myxxkimpl;
import dao.impl.UsersDaoImpl;
import db.DbHelp;
import dto.Returnmsg;
import net.sf.json.JSONObject;
import pojo.Users;

public class Updatepersonzlservlet extends HttpServlet{
      @Override
     public  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doPost(req, resp);
    }
      @Override
      public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	                 //resp.setHeader("Content-Type", "application/json,charset=utf-8");
    	                 resp.setHeader("Content-Type", "application/json,charset=utf-8");  
                         PrintWriter out=resp.getWriter();       
                         Connection conn =DbHelp.getConnection();
                         Myxxk dao =new Myxxkimpl();
                         UsersDaoImpl userdao=new UsersDaoImpl();
                         String   account  =req.getParameter("account");
                         String   datauser =req.getParameter("datauser");
                         //System.out.println(account);
                         //System.out.println(datauser);
                         JSONObject  obj =JSONObject.fromObject(datauser);         
                         String  usersphone=obj.getString("users_phone");
                         String  usersname=obj.getString("users_name");
                         String  usersnickname=obj.getString("users_nickname");
                         String  usersaddr=obj.getString("users_addr");
                         String  usersemail=obj.getString("users_email");
                         //System.out.println(usersphone+"0k");  
                              try {
                            	  
                            	if(account!=null){  
                               conn.setAutoCommit(false);
             
					      	   Users user=dao.selectUsers(account, conn);
				  
					      	   user.setUsers_phone(usersphone);
					      	   user.setUsers_name(usersname);
					      	   user.setUsers_nickname(usersnickname);
					      	   user.setUsers_addr(usersaddr);
					      	   user.setUsers_email(usersemail);
					      	   //System.out.println(user);
					      	   Boolean  userflag=userdao.updateUsers(user, conn);
					      	   conn.commit();
					      	     //成功
					      	   if(userflag){
					      		  Returnmsg msg0=new Returnmsg(0,"修改成功");
					      		  JSONObject ret0 =JSONObject.fromObject(msg0);
					      		  out.write(ret0.toString()); 
					      	   }else{
					      		  //失败
					      		 Returnmsg msg1=new Returnmsg(1,"修改失败");
					      		 JSONObject ret1 =JSONObject.fromObject(msg1);
					      		 out.write(ret1.toString()); 
					      	   }
                            	}
							} catch (Exception e) {
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
             }
}
