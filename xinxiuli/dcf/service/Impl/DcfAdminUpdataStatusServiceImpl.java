package service.Impl;

import java.sql.Connection;
import java.util.List;

import dao.DcfAdminUpdataStatusDao;
import dao.impl.DcfAdminUpdataStatusDaoImpl;
import db.DbHelp;
import pojo.Order;
import service.DcfAdminUpdataStatusService;

public class DcfAdminUpdataStatusServiceImpl implements DcfAdminUpdataStatusService{

	@Override
	public boolean adminUpdataStus(String accnum, int status) {
		Connection conn=DbHelp.getConnection();
		boolean flag=false;
		DcfAdminUpdataStatusDao daus=new DcfAdminUpdataStatusDaoImpl();
		try {
			flag=daus.updataStatus(accnum, status, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelp.closeConnection(conn);
		}
		return flag;
	}
}
