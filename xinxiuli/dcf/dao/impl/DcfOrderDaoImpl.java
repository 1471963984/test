package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.DcfOrderDao;
import pojo.Order;

public class DcfOrderDaoImpl implements DcfOrderDao{

	@Override
	public boolean insertOrder(Order order, Connection conn) throws Exception {
		return false;
	}

	@Override
	public boolean updateOrder(Order order, Connection conn) throws Exception {
		return false;
	}

	@Override
	public List<Order> selectAllOrder(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> selectAllUserOrders(String accountnum,int status,Connection conn) throws Exception{	
		String sql = "select * from orders where account_num=? ";
		List<Order> list=new ArrayList<Order>();
		if(status>0) {
			sql+="and order_status=?";
		}
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,accountnum);
		if(status>0) {
			ps.setInt(2, status);
		}
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Order o = new Order();
			o.setOrder_num(rs.getInt("order_num"));
			o.setOrder_time(rs.getString("order_time"));
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
	public boolean deleteOrder(int order_num, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order selectOrder(int order_num, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> queryAdminUnshippedOrders(int status, Connection conn) throws Exception {
		String sql = "select * from orders where order_status=? ";
		List<Order> list=new ArrayList<Order>();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, status);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Order o = new Order();
			o.setOrder_num(rs.getInt("order_num"));
			o.setOrder_time(rs.getString("order_time"));
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
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public List<Order> AdminQueryOneUser(String accnum, Connection conn) throws Exception {
//		String sql = "select * from orders where accout_num=? ";
//		List<Order> list=new ArrayList<Order>();
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setInt(1, status);
//		ResultSet rs = ps.executeQuery();
//		while(rs.next()) {
//			Order o = new Order();
//			o.setOrder_num(rs.getInt("order_num"));
//			o.setOrder_time(rs.getString("order_time"));
//			o.setOrder_status(rs.getInt("order_status"));
//			o.setAccount_num(rs.getString("account_num"));
//			o.setColor_name(rs.getString("color_name"));
//			o.setSize_name(rs.getString("size_name"));
//			o.setGoods_name(rs.getString("goods_name"));
//			o.setGoods_phone(rs.getString("goods_phone"));
//			o.setShouhuoren(rs.getString("shouhuoren"));
//			o.setGoods_price(rs.getString("goods_price"));
//			o.setOrder_addrs(rs.getString("order_addrs"));
//			list.add(o);
//		}
//		return list;
//	}

}
