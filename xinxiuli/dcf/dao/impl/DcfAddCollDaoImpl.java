package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import dao.DcfAddCollDao;
import pojo.Account;

public class DcfAddCollDaoImpl implements DcfAddCollDao{

	@Override
	public boolean insertAccount(Account account, Connection conn) throws Exception {
		return false;
	}

	@Override
	public boolean updateAccount(Account account, Connection conn) throws Exception {
		return false;
	}

	@Override
	public boolean deleteAccount(String account_num, Connection conn) throws Exception {
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

	@Override
	public boolean updateAccount(String account_num, String coll_goods, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
//	根据账号查询用户收藏，再添加
	@Override
	public boolean addColl(String accnum, String goodsid,Connection conn) throws Exception {
		boolean flag=false;
		String sql = "update account set coll_goods=? where account_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,goodsid);
		ps.setString(2,accnum);
		int result=ps.executeUpdate();
		if(result>0) {
			flag = true;
		}
		return flag;
	}

}
