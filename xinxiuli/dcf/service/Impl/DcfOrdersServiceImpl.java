package service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.DcfOrderDao;
import dao.impl.DcfOrderDaoImpl;
import db.DbHelp;
import pojo.Order;
import service.DcfOrdersService;

public class DcfOrdersServiceImpl implements DcfOrdersService{
	private static final Logger log = Logger.getLogger(DcfOrdersServiceImpl.class);
	@Override
	public List<Order> selectAllUserOrders(String accountnum, int status) {
		 Connection conn=DbHelp.getConnection();
	     List<Order> list=new ArrayList<Order>();	
	     DcfOrderDao dfd=new DcfOrderDaoImpl();
		try {
			list=dfd.selectAllUserOrders(accountnum, status, conn);		
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
		return list;
	}
}
