package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Testutil.Helper;
import dao.Myxxk;
import dao.impl.CartDaoImpl;
import pojo.Account;
import pojo.Cart;
import pojo.Users;

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

	@Override
	public Users selectUsers(String account_num, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from users where account_num=?";
		Users u = null;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,account_num);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			u = new Users();
			u.setUsers_id(rs.getInt("users_id"));
			u.setAccount_num(rs.getString("account_num"));
			u.setUsers_name(rs.getString("users_name"));
			u.setUsers_nickname(rs.getString("users_nickname"));
			u.setUsers_addr(rs.getString("users_addr"));
			u.setUsers_email(rs.getString("users_email"));
			u.setUsers_phone(rs.getString("users_phone"));
		}
		return u;
	} 
	
	
	public boolean updateAccount(String account_num, String account_pass, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update account set account_pass=? where account_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, account_pass);
		ps.setString(2, account_num);
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}
	
	
	
//   public static void main(String[] args) {
//	   Myxxkimpl  dao=new Myxxkimpl();
//	  Connection  conn=Helper.getcon();
//	  CartDaoImpl  Cartdao=new CartDaoImpl();   
//    //    Cart cart=new  Cart();	    	        	             
//     //   cart.setCart_num("14242rwe34tw");
//     //   cart.setGoods_id("1");
//    //    cart.setGoods_count(12);
//           
//	   try {
//		// boolean flag=dao.updateAccount("15673876615","1234567x", conn) ;
//		//    System.out.println(flag);
//	//	Cartdao.insertCart(cart, conn);
//	//   System.out.println(dao.selectUsers("15673876615", conn).toString());
//    //		  System.out.println(dao.selectaccount("15673876615", conn));
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//   }
	
}
              