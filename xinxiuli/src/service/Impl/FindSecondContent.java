package service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import dao.Second_contentDao;
import dao.impl.Second_contentDaoImpl;
import db.DbHelp;
import pojo.Second_content;

public class FindSecondContent implements service.FindSecondContent{
	private static final Logger log = Logger.getLogger(FindSecondContent.class);
	@Override
	public List<Second_content> findSecondContent(int first_num) {
		Second_contentDao dao = new Second_contentDaoImpl();
		List<Second_content> list = null;
		Connection conn = DbHelp.getConnection();
		try {
			list = dao.selectAllSecond_content(first_num, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
		}finally{
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
