package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDao;
import dao.Goods_colorDao;
import dao.Goods_sizeDao;
import dao.PersonCartDao;
import dao.impl.GoodsDaoImpl;
import dao.impl.Goods_colorDaoImpl;
import dao.impl.Goods_sizeDaoImpl;
import dao.impl.PersonCartDaoImpl;
import db.DbHelp;
import dto.ShowMyCart;
import net.sf.json.JSONArray;
import pojo.Account;
import pojo.Goods;
import pojo.Goods_color;
import pojo.Goods_size;
import service.ShowCartService;
import serviceImpl.ShowCartServiceImpl;

public class MyCartServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 this.doPost(req, resp);
	}
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Account account	=(Account)request.getSession().getAttribute("account");
	    if(account!=null) {
	    	String account_num = account.getAccount_num();
	    	ShowCartService service = new ShowCartServiceImpl();
	    	List<ShowMyCart> list = new ArrayList<ShowMyCart>();
	    	try {
	    		list = service.selectAllMygoods(account_num);
	    		JSONArray ja = JSONArray.fromObject(list);
	    		response.setCharacterEncoding("utf-8");
	    		response.setHeader("Content-Type", "application/json;charset=utf-8");
	    		PrintWriter out = response.getWriter();
	    		out.print(URLDecoder.decode(ja.toString()));
	    		out.flush();
	    		out.close();
	    	} catch (Exception e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    }
	}
}
