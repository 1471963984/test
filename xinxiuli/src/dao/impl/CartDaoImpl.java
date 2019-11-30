package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.CartDao;
import db.DbHelp;
import pojo.Cart;

public class CartDaoImpl implements CartDao{

	@Override
	public boolean insertCart(Cart cart, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into cart(cart_num,goods_id,goods_count) values (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, cart.getCart_num());
		ps.setString(2, cart.getGoods_id());
		ps.setInt(3, cart.getGoods_count());
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public boolean updateCart(Cart cart, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update cart set goods_id=?,goods_count=? where cart_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, cart.getGoods_id());
		ps.setInt(2, cart.getGoods_count());
		ps.setString(3, cart.getCart_num());
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteCart(String cart_num, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from cart where cart_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, cart_num);
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public Cart selectCart(String cart_num, Connection conn) throws Exception {
		String sql = "select * from cart where cart_num=?";
		Cart c = null;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, cart_num);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			c = new Cart();
			c.setCart_num(rs.getString("cart_num"));
			c.setGoods_id(rs.getString("goods_id"));
			c.setGoods_count(rs.getInt("goods_count"));
		}
		return c;
	}

	@Override
	public List<Cart> selectAllCart(Connection conn) throws Exception {
		List<Cart> list = new ArrayList<Cart>();
		String sql = "select * from cart";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Cart c = new Cart();
			c.setCart_num(rs.getString("cart_num"));
			c.setGoods_id(rs.getString("goods_id"));
			c.setGoods_count(rs.getInt("goods_count"));
			list.add(c);
		}
		return list;
	}

	@Override
	public boolean updateCartById(String cart_num,String goods_id, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update cart set goods_id=? where cart_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, goods_id);
		ps.setString(2, cart_num);
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}


}
