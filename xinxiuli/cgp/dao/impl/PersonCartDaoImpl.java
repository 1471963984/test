package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.GoodsDao;
import dao.PersonCartDao;
import db.DbHelp;
import pojo.Account;
import pojo.Goods;

public class PersonCartDaoImpl implements PersonCartDao{

	@Override
	public String selectAllMyGoods(String account_num,Connection conn) throws Exception {
		String goods_num = null;
		String sql = "select cart.goods_id FROM account INNER JOIN cart ON account.cart_num = cart.cart_num  where account.account_num = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, account_num);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			goods_num = rs.getString("goods_id");
		}
		return goods_num;
	}
	

	@Override
	public boolean insertAccount(Account account, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAccount(Account account, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(String account_num, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account selectAccount(String account_num, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> selectAllAccount(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String selectCartGoods(String account_num, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
