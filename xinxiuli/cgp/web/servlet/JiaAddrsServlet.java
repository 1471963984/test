package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import dao.UsersDao;
import dao.UsersZiLiaoDao;
import dao.impl.GoodsDaoImpl;
import dao.impl.Goods_colorDaoImpl;
import dao.impl.Goods_sizeDaoImpl;
import dao.impl.PersonCartDaoImpl;
import dao.impl.UsersDaoImpl;
import dao.impl.UsersZiLiaoDaoImpl;
import db.DbHelp;
import dto.ShowMyCart;
import net.sf.json.JSONObject;
import pojo.Account;
import pojo.Goods;
import pojo.Goods_color;
import pojo.Goods_size;
import pojo.Users;
import service.AddAddrsService;
import serviceImpl.AddAddrsServiceImpl;

public class JiaAddrsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取连接，通过账号获得购物车商品字符串
		
		Account account	=(Account)request.getSession().getAttribute("account");
		AddAddrsService ads = new AddAddrsServiceImpl();
		//获取传过来的值,插入到数据库
	    String u = request.getParameter("user");
	    Users user = null;
	    if(u!=null){
	    	JSONObject jo = JSONObject.fromObject(u);
	    	user = (Users) JSONObject.toBean(jo, Users.class);
	    }
		try {
			//将添加的地址加入数据库
			boolean b=ads.addAddrs(account.getAccount_num(),user);
			PrintWriter out=response.getWriter();
			out.print(b);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
