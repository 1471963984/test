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

import Testutil.Myutil;
import dao.imp.Myxxkimpl;
import db.DbHelp;
import dto.Returnmsg;
import net.sf.json.JSONObject;
import service.Impl.FindDiviedGoods;

public class Updatepasswordcheck  extends HttpServlet{
	private static final Logger log = Logger.getLogger(Updatepasswordcheck.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   this.doPost(req, resp);
	 }
        @Override
     public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	// TODO Auto-generated method stub
        	 resp.setHeader("Content-Type", "application/json,charset=utf-8");  
             PrintWriter out =resp.getWriter();
             
      	     resp.setCharacterEncoding("utf-8");
      	     Connection  conn =DbHelp.getConnection();
      	    
      	     String  databean =req.getParameter("databean");
           
      	     JSONObject  obj =JSONObject.fromObject(databean);
      	     String      account     =obj.getString("account");  
             String     password     =obj.getString("password");
            // System.out.println(account+"===="+password);
             
             Myxxkimpl  dao =new Myxxkimpl();
             try {
            	 if(account!=null&&password!=null){
            	//md5
				 Boolean  flag=dao.selectaccountinfo(account,Myutil.Encryptin(password), conn);
			     if(flag){
			         Returnmsg  msg0=new Returnmsg(0,"*正确");
			         JSONObject objmsg0=JSONObject.fromObject(msg0);
			         out.write(objmsg0.toString());
			         out.flush();		   
			     }else{
			    	 Returnmsg  msg1=new Returnmsg(1,"*您的密码输入错误");
			         JSONObject objmsg1=JSONObject.fromObject(msg1);
			         out.write(objmsg1.toString());
			         out.flush(); 
			       }	  
            	 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(e);
			}finally{
				try {
					if(conn!=null&&!conn.isClosed()) {
						DbHelp.closeConnection(conn);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					log.error(e);
				}
			}    
             
             
        }
}
