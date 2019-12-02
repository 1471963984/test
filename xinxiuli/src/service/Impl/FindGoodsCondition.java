package service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;
import db.DbHelp;
import pojo.Goods;

public class FindGoodsCondition implements service.FindGoodsCondition{

	@Override
	public List<Goods> findGoodsCondition(Map<String, String> map) {
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = DbHelp.getConnection();
		GoodsDao dao = new GoodsDaoImpl();
		try {
			list = dao.selectAllGoodsByCondition(map, conn);
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
