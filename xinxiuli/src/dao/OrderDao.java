package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Order;


public interface OrderDao {
	public boolean insertOrder(Order goods,Connection conn);
	public boolean updateOrder(Order goods,Connection conn);
	public boolean deleteOrder(String order_num,Connection conn);
	public Order selectOrder(String order_num,Connection conn);
	public List<Order> selectAllOrder(Connection conn);
}
