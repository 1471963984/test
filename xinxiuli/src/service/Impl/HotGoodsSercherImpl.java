package service.Impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;
import db.DbHelp;
import pojo.Goods;
import service.HotGoodsSercher;

public class HotGoodsSercherImpl implements HotGoodsSercher{

	@Override
	public List<Goods> sercherGoods(String desc) {
		GoodsDao dao = new GoodsDaoImpl();
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = DbHelp.getConnection();
		try {
			list = dao.selectGoodsByDesc(desc, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
