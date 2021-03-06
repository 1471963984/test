package service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;
import db.DbHelp;
import pojo.Goods;

public class FindGoodsCondition implements service.FindGoodsCondition{
	private static final Logger log = Logger.getLogger(FindGoodsCondition.class);
	@Override
	public List<Goods> findGoodsCondition(Map<String, String> map) {
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = DbHelp.getConnection();
		GoodsDao dao = new GoodsDaoImpl();
		try {
			list = dao.selectAllGoodsByCondition(map, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
		} finally {
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
