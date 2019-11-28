package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DcfOrderDao;
import dao.impl.DcfOrderDaoImpl;
import net.sf.json.JSONArray;
import pojo.Account;
import pojo.Order;
import service.DcfOrdersService;
import service.Impl.DcfOrdersServiceImpl;

public class MyOrder extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account a=new Account();
		//Account accnum=(Account)request.getSession().getAttribute("account");
		String accnum="123";
		String sta=request.getParameter("status");
	    DcfOrdersService dcf=new DcfOrdersServiceImpl();
		List<Order> list=new ArrayList<Order>();
		PrintWriter out=response.getWriter();
	    
		 if(sta==null) {
		//	 list=dcf.selectAllUserOrders(accnum.getAccount_num(),-1);
			 list=dcf.selectAllUserOrders(accnum,-1);
			 request.setAttribute("list",list);
			 request.getRequestDispatcher("/xinxiuli/qianduanyemian/myorders.jsp").forward(request, response);
			 return;
		 }else {
			// list=dcf.selectAllUserOrders(accnum.getAccount_num(), Integer.valueOf(sta));	 
			 list=dcf.selectAllUserOrders(accnum, Integer.valueOf(sta));
			 JSONArray arr=JSONArray.fromObject(list);
	    	 out.print(arr.toString());
	    	 return;
		 }
		 
	}

}
