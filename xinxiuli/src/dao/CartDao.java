package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Cart;

public interface CartDao {
	public boolean insertCart(Cart cart,Connection conn) throws Exception;
	public boolean updateCart(Cart cart,Connection conn) throws Exception;
	public boolean deleteCart(String cart_num,Connection conn) throws Exception;
	public Cart selectCart(String cart_num,Connection conn) throws Exception;
	public List<Cart> selectAllCart(Connection conn) throws Exception;
}
