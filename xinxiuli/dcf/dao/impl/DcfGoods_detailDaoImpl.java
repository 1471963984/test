package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dao.DcfGoods_detailDao;
import pojo.Goods_detail;

public class DcfGoods_detailDaoImpl implements DcfGoods_detailDao{

	@Override
	public boolean insertGoods_detail(Goods_detail goods_detail, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGoods_detail(Goods_detail goods_detail, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGoods_detail(int detail_id, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Goods_detail selectGoods_color(int detail_id, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods_detail> selectAllGoods_detail(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public Goods_detail queryPhoto(int goodsid,Connection conn) throws Exception{
		Goods_detail g = null;
		String sql = "select * from goods_detail where goods_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, goodsid);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			g = new Goods_detail();
			g.setDetail_id(rs.getInt("detail_id"));
			g.setGoods_id(rs.getInt("goods_id"));
			g.setFirst_picture(rs.getString("first_picture"));
			g.setSecond_picture(rs.getString("second_picture"));
			g.setThried_picture(rs.getString("thried_picture"));
			g.setDetails_picture(rs.getString("details_picture"));
		}	
		return g;
	}
}
