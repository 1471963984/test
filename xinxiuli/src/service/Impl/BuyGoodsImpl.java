package service.Impl;

import java.sql.Connection;
import java.sql.SQLException;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import db.DbHelp;
import service.BuyGoods;

public class BuyGoodsImpl implements BuyGoods{

	@Override
	public boolean buyGoods(int ordernum) {
		boolean flag = false;
		Connection conn = DbHelp.getConnection();
		OrderDao dao = new OrderDaoImpl();
		try {
			flag = dao.updateOrder(ordernum, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null&&!conn.isClosed()) {
					DbHelp.closeConnection(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

}
