package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.AccountDao;
import db.DbHelp;
import pojo.Account;

public class AccountDaoImpl implements AccountDao{

	@Override
	public boolean insertAccount(Account account, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into account(account_id,account_num,account_pass,users_ip,cart_num,order_num,coll_goods) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, account.getAccount_id());
		ps.setString(2, account.getAccount_num());
		ps.setString(3, account.getAccount_pass());
		ps.setString(4, account.getUsers_ip());
		ps.setString(5, account.getCart_num());
		ps.setString(6, account.getOrder_num());
		ps.setInt(7, account.getColl_goods());
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateAccount(Account account, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update account set account_id=?,account_pass=?,users_ip=?,cart_num=?,order_num=?,coll_goods=? where account_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, account.getAccount_id());
		ps.setString(2, account.getAccount_pass());
		ps.setString(3, account.getUsers_ip());
		ps.setString(4, account.getCart_num());
		ps.setString(5, account.getOrder_num());
		ps.setInt(6, account.getColl_goods());
		ps.setString(7, account.getAccount_num());
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteAccount(String account_num, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from account where account_num=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account_num);
			if(ps.executeUpdate()>0) {
				flag = true;
			}
		return flag;
	}

	@Override
	public Account selectAccount(String account_num, Connection conn) throws Exception {
		Account a = null;
		String sql = "select * from account where account_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, account_num);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			a = new Account();
			a.setAccount_id(rs.getInt("account_id"));
			a.setAccount_num(rs.getString("account_num"));
			a.setAccount_pass(rs.getString("account_pass"));
			a.setUsers_ip(rs.getString("users_ip"));
			a.setCart_num(rs.getString("cart_num"));
			a.setOrder_num(rs.getString("order_num"));
			a.setColl_goods(rs.getInt("coll_goods"));
		}
		return a;
	}

	@Override
	public List<Account> selectAllAccount(Connection conn) throws Exception {
		List<Account> list = new ArrayList<Account>();
		Account a = null;
		String sql = "select * from account";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			a = new Account();
			a.setAccount_id(rs.getInt("account_id"));
			a.setAccount_num(rs.getString("account_num"));
			a.setAccount_pass(rs.getString("account_pass"));
			a.setUsers_ip(rs.getString("users_ip"));
			a.setCart_num(rs.getString("cart_num"));
			a.setOrder_num(rs.getString("order_num"));
			a.setColl_goods(rs.getInt("coll_goods"));
			list.add(a);
		}
		
		return list;
	}
}
