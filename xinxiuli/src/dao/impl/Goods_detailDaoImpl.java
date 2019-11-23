package dao.impl;

import java.sql.Connection;
import java.util.List;

import dao.Goods_detailDao;
import pojo.Goods_detail;

public class Goods_detailDaoImpl implements Goods_detailDao{

	@Override
	public boolean insertGoods_detail(Goods_detail goods_detail, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGoods_detail(Goods_detail goods_detail, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGoods_detail(int detail_id, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Goods_detail selectGoods_color(int detail_id, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods_detail> selectAllGoods_detail(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}
