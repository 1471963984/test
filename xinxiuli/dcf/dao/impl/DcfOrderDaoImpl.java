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
			o.setGoods_id(rs.getInt("goods_id"));
			o.setOrder_status(rs.getInt("order_status"));
			o.setAccount_num(rs.getString("account_num"));
			o.setColor_num(rs.getInt("color_num"));
			o.setSize_num(rs.getInt("size_num"));
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



}
