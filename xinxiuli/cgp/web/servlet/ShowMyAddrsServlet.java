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

import dao.UsersZiLiaoDao;
import dao.impl.UsersZiLiaoDaoImpl;
import db.DbHelp;
import net.sf.json.JSONArray;
import pojo.Account;
import pojo.Users;

public class ShowMyAddrsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DbHelp.getConnection();
		Account account	=(Account)request.getSession().getAttribute("account");
		if(account!=null) {
			String account_num = account.getAccount_num();
			UsersZiLiaoDao uzd = new UsersZiLiaoDaoImpl();
			List<Users> list = null;
			if(account_num!=null){
				try {
					list = uzd.selectAllUsersByAccount_num(account_num, conn);
					JSONArray ja = JSONArray.fromObject(list);
					response.setCharacterEncoding("utf-8");
					response.setHeader("Content-Type", "application/json;charset=utf-8");
					PrintWriter out = response.getWriter();
					out.print(ja.toString());
					out.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
