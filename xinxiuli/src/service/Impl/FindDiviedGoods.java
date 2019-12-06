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

public class FindDiviedGoods implements service.FindDiviedGoods{
	private static final Logger log = Logger.getLogger(FindDiviedGoods.class);
	@Override
	public List<Goods> findDiviedGoods(int divied_num){
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = DbHelp.getConnection();
		GoodsDao dao = new GoodsDaoImpl();
		try {
			list = dao.selectAllDiviedGoods(divied_num, conn);
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
