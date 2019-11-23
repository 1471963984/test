package dao.impl;

import java.sql.Connection;
import java.util.List;

import dao.OrderDao;
import pojo.Order;

public class OrderDaoImpl implements OrderDao{

	@Override
	public boolean insertOrder(Order goods, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOrder(Order goods, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOrder(String order_num, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order selectOrder(String order_num, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> selectAllOrder(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}
