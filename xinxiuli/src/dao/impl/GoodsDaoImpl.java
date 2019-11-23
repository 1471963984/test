package dao.impl;

import java.sql.Connection;
import java.util.List;

import dao.GoodsDao;
import pojo.Goods;

public class GoodsDaoImpl implements GoodsDao{

	@Override
	public boolean insertGoods(Goods goods, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGoods(Goods goods, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGoods(int goods_id, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Goods selectGoods(int goods_id, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> selectAllGoods(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}
