package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.AdminAllUserInfo;
import net.sf.json.JSONArray;
import pojo.Users;
import service.DcfAdminShowUsersService;
import service.Impl.DcfAdminShowUsersServiceImpl;

public class AdminShowUsers extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  DcfAdminShowUsersService dasu=new  DcfAdminShowUsersServiceImpl();
    	  List<AdminAllUserInfo> l=new ArrayList<AdminAllUserInfo>();
    	  l=dasu.showUsers();
    	  JSONArray job=JSONArray.fromObject(l);
    	  PrintWriter out=response.getWriter();
    	  out.print(job.toString());
    }
}
