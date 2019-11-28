package service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.First_contentDao;
import dao.impl.First_contentDaoImpl;
import db.DbHelp;
import pojo.First_content;

public class FindFirstContent implements service.FindFirstContent{

	@Override
	public List<First_content> findFirstContent() {
		First_contentDao dao = new First_contentDaoImpl();
		Connection conn = DbHelp.getConnection();
		List<First_content> list = null;
		try {
			list = dao.selectAllFirst_content(conn);
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
		return list;
	}

}
