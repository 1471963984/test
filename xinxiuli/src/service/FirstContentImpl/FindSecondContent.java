package service.FirstContentImpl;

import java.sql.Connection;
import java.util.List;

import dao.Second_contentDao;
import dao.impl.Second_contentDaoImpl;
import db.DbHelp;
import pojo.Second_content;

public class FindSecondContent implements service.FindSecondContent{

	@Override
	public List<Second_content> findSecondContent(int first_num) {
		Second_contentDao dao = new Second_contentDaoImpl();
		List<Second_content> list = null;
		Connection conn = DbHelp.getConnection();
		try {
			list = dao.selectAllSecond_content(first_num, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
