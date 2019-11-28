package web.servlet;

import java.io.IOException;
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
	   //获取连接，通过账号获得购物车商品字符串
	   Connection conn = DbHelp.getConnection();
	   	PersonCartDao pcd = new PersonCartDaoImpl();
	     
	    Account account	=(Account)request.getSession().getAttribute("account");
	    String account_num = account.getAccount_num();
	    String goods_num = null;
		try {
			goods_num = pcd.selectAllMyGoods(account_num,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(goods_num);
		//拆分字符串获取对应商品
		String[] allgoods = goods_num.split(",");
//		System.out.println(allgoods.length);
		//准备存dto的集合
		List<ShowMyCart> list = new ArrayList<ShowMyCart>();
		//查询对应商品并封装成dto
		GoodsDao gd = new GoodsDaoImpl();
		Goods_colorDao cd = new Goods_colorDaoImpl();
		Goods_sizeDao sd = new Goods_sizeDaoImpl();
		for (int i = 0; i < allgoods.length; i++) {
			//通过goods_num找到唯一对应的商品
			try {
				Goods g = gd.selectGoods(Integer.parseInt(allgoods[i]),conn);
				ShowMyCart s = new ShowMyCart();
				s.setGoods_img(g.getGoods_picture());
				s.setGoods_desc(g.getGoods_desc());
				s.setGoods_name(g.getGoods_name());
				//颜色和尺寸还要查
				Goods_color color = cd.selectGoods_colorOne(g.getGoods_id(),g.getGoods_color_num(), conn);
				s.setGoods_color(color.getColor_name());
				Goods_size size = sd.selectGoods_sizeOne(g.getGoods_id(), g.getGoods_color_num(), g.getGoods_size_num(), conn);
				s.setGoods_size(size.getSize_name());
				s.setGoods_price(g.getGoods_price());
				s.setList_size(String.valueOf(list.size()));
				list.add(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		  request.setAttribute("goodslist",list);
		  request.getRequestDispatcher("/qianduanyemian/mycart.jsp").forward(request, response);
	}
}
