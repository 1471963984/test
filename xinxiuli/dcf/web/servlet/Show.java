package web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.AALOAD;

import dto.ShowOneGoods;
import pojo.Goods_size;
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
	      String gid="1";
		  String cid=request.getParameter("cid");
		  DcfService ds=new DcfServiceImpl();
		  ShowOneGoods sog=new ShowOneGoods();
		  List<Goods_size> list=new ArrayList<>();
		  if(gid!=null&&cid==null) {
			 sog=ds.show(Integer.parseInt(gid));		 
			 for(int i=0;i<sog.getLsize().size();i++) {
				 if(sog.getGoods_id()==sog.getLsize().get(i).getGoods_id()&&
					sog.getL().get(1).getColor_num()==sog.getLsize().get(i).getColor_num()	 
						 ) {
					 list.add(sog.getLsize().get(i));
					 sog.setColorphoto(sog.getL().get(1).getGoods_delpicture().split(";"));
				 }
			 }
			  sog.setLsize(list);
		  }
		  if(gid!=null&&cid!=null) {
			  sog=ds.show(Integer.parseInt(gid));
			  for(int i=0;i<sog.getLsize().size();i++) {
					 if(sog.getGoods_id()==sog.getLsize().get(i).getGoods_id()&&
						Integer.parseInt(cid)==sog.getLsize().get(i).getColor_num()	 
							 ) {
						 list.add(sog.getLsize().get(i));
						 sog.setColorphoto(sog.getL().get((Integer.parseInt(cid)-1)).getGoods_delpicture().split(";"));
					 }
				 }
			  sog.setLsize(list);
		  }  
		  request.getSession().setAttribute("goods",sog);
		  request.getSession().setAttribute("cid", cid);
	      response.sendRedirect("/xinxiuli/qianduanyemian/productdetail.jsp"); 
	}
}
