package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ShowOneGoods;
import service.DcfService;
import service.Impl.DcfServiceImpl;

public class Show extends HttpServlet{
   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 this.doPost(req, resp);
	}
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		  String gid=request.getParameter("gid");
		  DcfService ds=new DcfServiceImpl();
		  ShowOneGoods sog=new ShowOneGoods();
////		  if(gid!=null) {
//			 sog=ds.show(Integer.parseInt(gid));
//		  }
		  sog=ds.show(1);
		  request.getSession().setAttribute("goods",sog);
		  response.sendRedirect("qianduanyemian/productdetail.jsp");
	}
}
