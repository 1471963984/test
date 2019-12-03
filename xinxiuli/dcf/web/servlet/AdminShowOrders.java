package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import pojo.Order;
import service.DcfAdminShowOrdersService;
import service.Impl.DcfAdminShowOrdersServiceImpl;

public class AdminShowOrders extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	this.doPost(req, resp);
    }
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 DcfAdminShowOrdersService dasos=new DcfAdminShowOrdersServiceImpl();
    	 List<Order> l=dasos.showOrders();
    	 JSONArray jso=JSONArray.fromObject(l);
    	 PrintWriter out=response.getWriter();
    	 out.print(jso.toString());
    }
}
