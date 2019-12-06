package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dao.MyOrderDao;
import pojo.Account;
import pojo.MyOrders;
import pojo.Order;
import web.servlet.MyOrder;

public class MyOrderDaoImpl implements MyOrderDao{

	@Override
	public boolean updateOrder(Order order, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public List<Order> selectAllOrder(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertOrder(MyOrders order, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into orders(order_num,goods_id,order_status,account_num,order_time,size_num,color_num) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, order.getOrder_num());
		ps.setInt(2, order.getGoods_id());
		ps.setInt(3, order.getOrder_status());
		ps.setString(4, order.getAccount_num());
		ps.setString(5, order.getOrder_time());
		ps.setInt(6, order.getSize_num());
		ps.setInt(7, order.getColor_num());
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public boolean insertOrder(Order order, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public boolean updateAccount(String account_num, String coll_goods, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MyOrders selectOrderByAccount_num(String account_num, Connection conn) throws Exception {
		String sql = "select * from orders where account_num=?";
		MyOrders o = null;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, account_num);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			o = new MyOrders();
			o.setOrder_num(rs.getInt("order_num"));
			o.setGoods_id(rs.getInt("goods_id"));
			o.setOrder_status(rs.getInt("order_status"));
			o.setAccount_num(rs.getString("account_num"));
			o.setOrder_time(rs.getString("order_time"));
			o.setSize_num(rs.getInt("size_num"));
			o.setColor_num(rs.getInt("color_num"));
			o.setOrder_addrs(rs.getString("order_addrs"));
		}
		
		return o;
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
	public boolean updateOrder(int order_num, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
}
