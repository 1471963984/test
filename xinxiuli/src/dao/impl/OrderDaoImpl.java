package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import db.DbHelp;
import pojo.Order;

public class OrderDaoImpl implements OrderDao{

	@Override
	public boolean insertOrder(Order order, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into order(order_num,order_time,goods_id,order_status,account_num,) values(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, order.getOrder_num());
		ps.setString(2, order.getOrder_time());
		ps.setInt(3, order.getGoods_id());
		ps.setInt(4, order.getOrder_status());
		ps.setString(5, order.getAccount_num());
		ps.setInt(6, order.getUsers_id());
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public boolean updateOrder(Order order, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update order set order_time=?,goods_id=?,order_status=?,account_num=?,users_id=? where order_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, order.getOrder_time());
		ps.setInt(2, order.getGoods_id());
		ps.setInt(3, order.getOrder_status());
		ps.setString(4, order.getAccount_num());
		ps.setInt(5, order.getUsers_id());
		ps.setString(6, order.getOrder_num());
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public boolean deleteOrder(String order_num, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from order where order_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, order_num);
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public Order selectOrder(String order_num, Connection conn) throws Exception {
		String sql = "select * from order where order_num=?";
		Order o = null;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, order_num);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			o = new Order();
			o.setOrder_num(rs.getString("order_num"));
			o.setOrder_time(rs.getString("order_time"));
			o.setGoods_id(rs.getInt("goods_id"));
			o.setOrder_status(rs.getInt("order_status"));
			o.setAccount_num(rs.getString("account_num"));
			o.setUsers_id(rs.getInt("users_id"));
		}
		
		return o;
	}

	@Override
	public List<Order> selectAllOrder(Connection conn) throws Exception {
		List<Order> list = new ArrayList<Order>();
		Order o = null;
		String sql = "select * from order";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			o = new Order();
			o.setOrder_num(rs.getString("order_num"));
			o.setOrder_time(rs.getString("order_time"));
			o.setGoods_id(rs.getInt("goods_id"));
			o.setOrder_status(rs.getInt("order_status"));
			o.setAccount_num(rs.getString("account_num"));
			o.setUsers_id(rs.getInt("users_id"));
			list.add(o);
		}
		
		return list;
	}

}
