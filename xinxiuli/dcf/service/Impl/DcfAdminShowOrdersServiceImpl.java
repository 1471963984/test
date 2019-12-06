package service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.DcfOrderDao;
import dao.OrderDao;
import dao.impl.DcfOrderDaoImpl;
import dao.impl.OrderDaoImpl;
import db.DbHelp;
import pojo.Order;
import service.DcfAdminShowOrdersService;

public class DcfAdminShowOrdersServiceImpl implements DcfAdminShowOrdersService{
	private static final Logger log = Logger.getLogger(DcfAdminShowOrdersServiceImpl.class);
	@Override
	public List<Order> showOrders() {
		Connection conn=DbHelp.getConnection();
		List<Order> l=new ArrayList<Order>();
		try {
			OrderDao od=new OrderDaoImpl();
			  l=od.selectAllOrder(conn);	
		} catch (Exception e) {
			log.error(e);
		}finally {
			try {
				if(conn!=null&&!conn.isClosed()) {				
					DbHelp.closeConnection(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
		}	
		return l;
	}
	
	public List<Order> AdminQueryUnshipped(int statas){
		Connection conn=DbHelp.getConnection();
		List<Order> l=new ArrayList<Order>();
		try {
			DcfOrderDao dod=new DcfOrderDaoImpl();
			  l=dod.queryAdminUnshippedOrders(statas, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelp.closeConnection(conn);
		}	
		return l;
	}

	@Override
	public List<Order> AdminQueryOneUser(String accnum) {
		Connection conn=DbHelp.getConnection();
		List<Order> l=new ArrayList<Order>();
		try {
			DcfOrderDao dod=new DcfOrderDaoImpl();
			  l=dod.selectAllUserOrders(accnum, -1, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelp.closeConnection(conn);
		}	
		return l;
	}
     
}
