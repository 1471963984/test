package service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;
import db.DbHelp;
import pojo.Goods;
import service.SelectGoods;

public class SelectGoodsImpl implements SelectGoods{

	@Override
	public List<Goods> selectGoods() {
		Connection conn = DbHelp.getConnection();
		GoodsDao dao = new GoodsDaoImpl();
		List<Goods> list = new ArrayList<Goods>();
		try {
			list = dao.selectAllGoodsNo(conn);
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
