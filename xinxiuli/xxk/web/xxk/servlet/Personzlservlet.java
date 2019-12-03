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

import Testutil.Datahandle;
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
          String getaccount =req.getParameter("personzl");

            if(getaccount!=null){
	      	     Users user =Datahandle.dataloander(getaccount);
	      	     req.getSession().setAttribute("user",user); 
			     JSONObject  obj =JSONObject.fromObject(user);
               out.write(obj.toString());  
               out.flush();
             }
                                         
       }
}
