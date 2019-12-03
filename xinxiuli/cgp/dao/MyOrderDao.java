/**
 * 
 */
package dao;

import java.sql.Connection;

import pojo.MyOrders;
import pojo.Order;

/**
 * @author 陈广平
 *
 */
public interface MyOrderDao extends OrderDao,AccountDao{
	public boolean insertOrder(MyOrders order, Connection conn) throws Exception;
	public boolean updateAccountOrder(String account_num, String order_num, Connection conn) throws Exception ;
	public MyOrders selectOrderByAccount_num(String account_num, Connection conn) throws Exception;
	
}
