package service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;
import db.DbHelp;
import pojo.Goods;
import service.SelectGoods;

public class SelectGoodsImpl implements SelectGoods{
	private static final Logger log = Logger.getLogger(SelectGoodsImpl.class);
	@Override
	public List<Goods> selectGoods() {
		Connection conn = DbHelp.getConnection();
		GoodsDao dao = new GoodsDaoImpl();
		List<Goods> list = new ArrayList<Goods>();
		try {
			list = dao.selectAllGoodsNo(conn);
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
