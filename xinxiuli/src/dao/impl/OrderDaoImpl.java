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
		String sql = "insert into orders(order_num,order_time,goods_num,color_name,size_name,order_status,account_num,order_addrs,goods_price,goods_name,goods_phone,shouhuoren) values(null,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, order.getOrder_time());
		ps.setInt(2, order.getGoods_num());
		ps.setString(3, order.getColor_name());
		ps.setString(4, order.getSize_name());
		ps.setInt(5, order.getOrder_status());
		ps.setString(6, order.getAccount_num());
		ps.setString(7, order.getOrder_addrs());
		ps.setString(8, order.getGoods_price());
		ps.setString(9, order.getGoods_name());
		ps.setString(10, order.getGoods_phone());
		ps.setString(11, order.getShouhuoren());
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public boolean updateOrder(Order order, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update orders set order_time=?,goods_num=?,order_status=?,account_num=?,color_name=?,size_name=?,order_addrs=?,goods_name=?,goods_phone=?,shouhuoren=?,goods_price=? where order_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, order.getOrder_time());
		ps.setInt(2, order.getGoods_num());
		ps.setInt(3, order.getOrder_status());
		ps.setString(4, order.getAccount_num());
		ps.setString(5, order.getColor_name());
		ps.setString(6, order.getSize_name());
		ps.setString(7, order.getOrder_addrs());
		ps.setString(8, order.getGoods_name());
		ps.setString(9, order.getGoods_phone());
		ps.setString(10, order.getShouhuoren());
		ps.setString(11, order.getGoods_price());
		ps.setInt(12, order.getOrder_num());
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public boolean deleteOrder(int order_num, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from orders where order_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, order_num);
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public Order selectOrder(int order_num, Connection conn) throws Exception {
		String sql = "select * from orders where order_num=?";
		Order o = null;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, order_num);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			o = new Order();
			o.setOrder_num(rs.getInt("order_num"));
			o.setOrder_time(rs.getString("order_time"));
			o.setGoods_num(rs.getInt("goods_num"));
			o.setOrder_status(rs.getInt("order_status"));
			o.setAccount_num(rs.getString("account_num"));
			o.setColor_name(rs.getString("color_name"));
			o.setSize_name(rs.getString("size_name"));
			o.setGoods_name(rs.getString("goods_name"));
			o.setGoods_phone(rs.getString("goods_phone"));
			o.setShouhuoren(rs.getString("shouhuoren"));
			o.setGoods_price(rs.getString("goods_price"));
			o.setOrder_addrs(rs.getString("order_addrs"));
		}
		
		return o;
	}

	@Override
	public List<Order> selectAllOrder(Connection conn) throws Exception {
		List<Order> list = new ArrayList<Order>();
		Order o = null;
		String sql = "select * from orders";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			o = new Order();
			o.setOrder_num(rs.getInt("order_num"));
			o.setOrder_time(rs.getString("order_time"));
			o.setGoods_num(rs.getInt("goods_num"));
			o.setOrder_status(rs.getInt("order_status"));
			o.setAccount_num(rs.getString("account_num"));
			o.setColor_name(rs.getString("color_name"));
			o.setSize_name(rs.getString("size_name"));
			o.setGoods_name(rs.getString("goods_name"));
			o.setGoods_phone(rs.getString("goods_phone"));
			o.setShouhuoren(rs.getString("shouhuoren"));
			o.setGoods_price(rs.getString("goods_price"));
			o.setOrder_addrs(rs.getString("order_addrs"));
			list.add(o);
		}
		
		return list;
	}

	@Override
	public boolean updateOrder(int order_num, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update orders set order_status=? where order_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 2);
		ps.setInt(2, order_num);
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}

}
