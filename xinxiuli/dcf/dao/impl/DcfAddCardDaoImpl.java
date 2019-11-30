package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dao.DcfAddCardDao;
import pojo.Cart;

public class DcfAddCardDaoImpl implements DcfAddCardDao{

	@Override
	public boolean insertCart(Cart cart, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCart(Cart cart, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCart(String cart_num, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cart selectCart(String cart_num, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> selectAllCart(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addGoodsMyCard(String cartnum,String goodsid,Connection conn) throws Exception{
		boolean flag=false;
		String sql = "update cart set goods_id=? where cart_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,goodsid);
		ps.setString(2,cartnum);
		int result=ps.executeUpdate();
		if(result>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateCartById(String cart_num, String goods_id, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
