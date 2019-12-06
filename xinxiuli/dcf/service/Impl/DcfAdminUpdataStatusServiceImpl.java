package service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import dao.DcfAdminUpdataStatusDao;
import dao.impl.DcfAdminUpdataStatusDaoImpl;
import db.DbHelp;
import pojo.Order;
import service.DcfAdminUpdataStatusService;

public class DcfAdminUpdataStatusServiceImpl implements DcfAdminUpdataStatusService{
	private static final Logger log = Logger.getLogger(DcfAdminUpdataStatusDaoImpl.class);
	@Override
	public boolean adminUpdataStus(String accnum, int status) {
		Connection conn=DbHelp.getConnection();
		boolean flag=false;
		DcfAdminUpdataStatusDao daus=new DcfAdminUpdataStatusDaoImpl();
		try {
			flag=daus.updataStatus(accnum, status, conn);
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
		return flag;
	}
}
