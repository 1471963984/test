package web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbHelp;
import dto.CartGoods;
import pojo.Account;
import service.JieSuanService;
import service.UpdataKucunService;
import serviceImpl.JieSuanServiceImpl;
import serviceImpl.UpdataKucunServiceImpl;

public class UpdateKucunServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从session中拿到账号
		Account account	=(Account)request.getSession().getAttribute("account");
		String account_num = account.getAccount_num();
		//从结算拿到goods_num
		String num = request.getParameter("goods_num");
		System.out.println(num.toString());
		String[] str = num.split(",");
		UpdataKucunService uks = new UpdataKucunServiceImpl();
//		uks.gaiKucun(account_num, goods_num, goods_num);
		for (int i = 0; i < str.length; i++) {
			uks.gaiKucun(account_num, Integer.parseInt(str[i]));
//			uks.updateAccountOrder(o, account_num, conn);
		}
		
//		response.sendRedirect("index.jsp");
	}
}
