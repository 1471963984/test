package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Order;


public interface OrderDao {
	public boolean insertOrder(Order order,Connection conn) throws Exception;
	public boolean updateOrder(Order order,Connection conn) throws Exception;
	public boolean deleteOrder(String order_num,Connection conn) throws Exception;
	public Order selectOrder(String order_num,Connection conn) throws Exception;
	public List<Order> selectAllOrder(Connection conn) throws Exception;
}
