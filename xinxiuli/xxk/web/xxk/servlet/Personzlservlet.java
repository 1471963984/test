package web.xxk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Testutil.Myutil;
import dao.imp.Myxxkimpl;
import dao.impl.UsersDaoImpl;
import db.DbHelp;
import net.sf.json.JSONObject;
import pojo.Users;

public class Personzlservlet extends HttpServlet{
     @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	  this.doPost(req, resp);
    }

      @Override
     public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	  //设置响应数据格式
    	        resp.setHeader("Content-Type", "application/json,charset=utf-8");  
                PrintWriter out =resp.getWriter();
         	    resp.setCharacterEncoding("utf-8");
         	    Connection  conn =DbHelp.getConnection(); 
         	    //System.out.println("112233");
                String getaccount =req.getParameter("personzl");
               
              //System.out.println(getaccount+"person");
                
                Myxxkimpl  dao =new Myxxkimpl();
                          
                try {
                  if(getaccount!=null){
                	 conn.setAutoCommit(false);
				     Users users=dao.selectUsers(getaccount,conn);
				     conn.commit();
				  // System.out.println(users);
				     JSONObject  obj =JSONObject.fromObject(users);
                     out.write(obj.toString());  
                     out.flush();
                    
                //   System.out.println("cheng");
                      
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
				}finally{
					DbHelp.closeConnection(conn);
				}
                                         
       }
}
