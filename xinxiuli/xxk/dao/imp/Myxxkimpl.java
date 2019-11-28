package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Testutil.Helper;
import dao.Myxxk;
import pojo.Account;

public class Myxxkimpl implements Myxxk{
	@Override
	public boolean selectaccount(String account_num, Connection conn) throws Exception {
		boolean flag=false;
		String sql = "select * from account where account_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, account_num);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
		  flag=true;	
		}
		
		return flag;
	}

	@Override
	public boolean selectaccountinfo(String account_num, String account_pass, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql = "select * from account where account_num=?and account_pass=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, account_num);
		ps.setString(2, account_pass);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
		  flag=true;	
		}   
		     
		return flag;
	}
     
	public Account selectAccountwhole(String account_num, Connection conn) throws Exception {
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
			a.setColl_goods(rs.getString("coll_goods"));
		   }
		return a;
	}
	
}
              