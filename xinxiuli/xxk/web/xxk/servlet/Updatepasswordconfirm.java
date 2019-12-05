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
import db.DbHelp;
import dto.Returnmsg;
import net.sf.json.JSONObject;

public class Updatepasswordconfirm  extends HttpServlet{
        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	// TODO Auto-generated method stub
        	this.doGet(req, resp);
        }
        
        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
                               // resp.setHeader("Content-type", "application/json,charset=utf-8");
                               resp.setHeader("Content-Type", "application/json,charset=utf-8");  
                               PrintWriter out=resp.getWriter();       
                               Connection conn =DbHelp.getConnection();
                               String   confirmmsg =req.getParameter("confirmmsg");
                               
                               JSONObject objbean =JSONObject.fromObject(confirmmsg);
                               String account=objbean.getString("account");
                               String newpassword=objbean.getString("newpassword");
                               Myxxkimpl dao =new Myxxkimpl();
                               
                               try {
                            	   //md5
							    boolean flag =dao.updateAccount(account,Myutil.Encryptin(newpassword), conn);
							    //修改成功
							    if(flag){
							      Returnmsg msg0=new Returnmsg(0,"修改成功,请重新登录");
							      JSONObject  ret0=JSONObject.fromObject(msg0);
							      out.write(ret0.toString());
							      req.getSession().removeAttribute("account");
							    //修改失败
							     }else{
							    	 
							    	 Returnmsg msg1=new Returnmsg(1,"修改失败");
								     JSONObject  ret1=JSONObject.fromObject(msg1);
								     out.write(ret1.toString());
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
                         
             }
}
