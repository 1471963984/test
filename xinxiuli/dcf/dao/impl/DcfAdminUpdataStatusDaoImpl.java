package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import dao.DcfAdminUpdataStatusDao;
import pojo.Order;

public class DcfAdminUpdataStatusDaoImpl implements DcfAdminUpdataStatusDao{

	@Override
	public boolean insertOrder(Order order, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOrder(Order order, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
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
	public List<Order> selectAllOrder(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updataStatus(String accnum, int status,Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update orders set order_status=? where account_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, status);
		ps.setString(2, accnum);
		int n=ps.executeUpdate();
		if(n>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateOrder(int order_num, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
