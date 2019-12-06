package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import dao.UsersZiLiaoDao;
import dao.impl.UsersZiLiaoDaoImpl;
import db.DbHelp;
import dto.Addrs;
import dto.CartGoods;
import dto.JieSuanShow;
import net.sf.json.JSONArray;
import pojo.Account;
import pojo.Users;
import service.JieSuanService;
import service.Impl.FindDiviedGoods;
import serviceImpl.JieSuanServiceImpl;

public class JieSuanServlet extends HttpServlet{
	private static final Logger log = Logger.getLogger(JieSuanServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DbHelp.getConnection();
		//从session中拿到账号
		Account account	=(Account)request.getSession().getAttribute("account");
		String account_num = account.getAccount_num();
		//从购物车拿到要渲染的商品ID
		String num = request.getParameter("goods_num");
//		System.out.println(num.toString());
		String[] str = num.split(",");
		JieSuanService info = new JieSuanServiceImpl();
		List<CartGoods> cglist = new ArrayList<CartGoods>();
		//商品
		double zongjia = 0.0;
		for (int i = 0; i < str.length; i++) {
//			System.out.println(str[i]);
			int goods_num = Integer.parseInt(str[i]);
			if(account!=null) {
				try {
					CartGoods cg = info.getMyGoods(account_num, goods_num, conn);
					zongjia = zongjia + cg.getGoods_price();
//					System.out.println(cg.getGoods_color());
					cglist.add(cg);
				} catch (Exception e1) {
					log.error(e1);
				}
			}
		}
		//地址
		List<Addrs> as = info.getMyAddrs(account_num, conn);
		//将地址和商品封装成一个大dto
		JieSuanShow jss = new JieSuanShow();
		jss.setAddrs(as);
		jss.setGoods(cglist);
		request.setAttribute("myinfo",jss);
		request.setAttribute("zongjia",zongjia);
//		System.out.println(zongjia);
		request.getRequestDispatcher("loginafter/jiesuan.jsp").forward(request, response);
		
	}
}
