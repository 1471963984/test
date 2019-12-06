package web.xxk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import Testutil.Datahandle;
import dao.Myxxk;
import dao.imp.Myxxkimpl;
import dao.impl.UsersDaoImpl;
import db.DbHelp;
import dto.Returnmsg;
import net.sf.json.JSONObject;
import pojo.Users;
import service.Impl.FindDiviedGoods;

public class Updatepersonzlservlet extends HttpServlet{
	private static final Logger log = Logger.getLogger(Updatepersonzlservlet.class);  
	@Override
     public  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doPost(req, resp);
    }
      @Override
      public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	  resp.setHeader("Content-Type", "application/json,charset=utf-8");  
          PrintWriter out=resp.getWriter();       
          Connection conn =DbHelp.getConnection();
          Myxxk dao =new Myxxkimpl();
          UsersDaoImpl userdao=new UsersDaoImpl();
          String   account  =req.getParameter("account");
          String   datauser =req.getParameter("datauser");
          JSONObject  obj =JSONObject.fromObject(datauser);         
          String  usersphone=obj.getString("users_phone");
          if("".equals(usersphone)){usersphone="待完善";}
          
          String  usersname=obj.getString("users_name");
          if("".equals(usersname)){usersname="待完善";}
          
          String  usersnickname=obj.getString("users_nickname");
          if("".equals(usersnickname)){usersnickname="待完善";}
          
          String  usersaddr=obj.getString("users_addr");
          if("".equals(usersaddr)){usersaddr="待完善";}
          
          String  usersemail=obj.getString("users_email"); 
          if("".equals(usersemail)){usersemail="待完善";}
               try {
             	if(account!=null){  
                conn.setAutoCommit(false);
                  //查
		      	     Users user=dao.selectUsers(account, conn);
		      	     String[] phone =user.getUsers_phone().split(",");
		      	     user.setUsers_phone(user.getUsers_phone().replace(phone[0],usersphone)); 
		      	     String[] name =user.getUsers_name().split(",");
		      	     user.setUsers_name(user.getUsers_name().replace(name[0],usersname));
		      	     String[] nickname=user.getUsers_nickname().split(",");
		      	     user.setUsers_nickname(user.getUsers_nickname().replace(nickname[0],usersnickname));
		             String[] addr=user.getUsers_addr().split(",");
		             user.setUsers_addr(user.getUsers_addr().replace(addr[0],usersaddr));
		      	     String[] eamil=user.getUsers_email().split(",");
		      	     user.setUsers_email(user.getUsers_email().replace(eamil[0],usersemail));
		      	     Boolean  userflag=userdao.updateUsers(user, conn);
		      	     //覆盖原有user
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
					log.error(e);
					try {
						conn.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						log.error(e);
					}
				}finally{
					try {
						if(conn!=null&&!conn.isClosed()) {
							DbHelp.closeConnection(conn);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						log.error(e);					}
				}   
             }
}
