package service.Impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.DcfOrderDao;
import dao.impl.DcfOrderDaoImpl;
import db.DbHelp;
import pojo.Order;
import service.DcfOrdersService;

public class DcfOrdersServiceImpl implements DcfOrdersService{

	@Override
	public List<Order> selectAllUserOrders(String accountnum, int status) {
		 Connection conn=DbHelp.getConnection();
	     List<Order> list=new ArrayList<Order>();	
	     DcfOrderDao dfd=new DcfOrderDaoImpl();
		try {
			list=dfd.selectAllUserOrders(accountnum, status, conn);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
