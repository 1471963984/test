package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Goods_detailDao;
import db.DbHelp;
import pojo.Goods_detail;

public class Goods_detailDaoImpl implements Goods_detailDao{

	@Override
	public boolean insertGoods_detail(Goods_detail goods_detail, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into goods_detail(detail_id,goods_id,first_picture,second_picture,thried_picture,details_picture) values(null,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, goods_detail.getGoods_id());
		ps.setString(2, goods_detail.getFirst_picture());
		ps.setString(3, goods_detail.getSecond_picture());
		ps.setString(4, goods_detail.getThried_picture());
		ps.setString(5, goods_detail.getDetails_picture());
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		
		return flag;
	}

	@Override
	public boolean updateGoods_detail(Goods_detail goods_detail, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update goods_detail set goods_id=?,first_picture=?,second_picture=?,thried_picture=?,details_picture=? where detail_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, goods_detail.getGoods_id());
		ps.setString(2, goods_detail.getFirst_picture());
		ps.setString(3, goods_detail.getSecond_picture());
		ps.setString(4, goods_detail.getThried_picture());
		ps.setString(5, goods_detail.getDetails_picture());
		ps.setInt(6, goods_detail.getDetail_id());
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public boolean deleteGoods_detail(int detail_id, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from goods_detail where detail_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, detail_id);
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public Goods_detail selectGoods_color(int detail_id, Connection conn) throws Exception {
		Goods_detail g = null;
		String sql = "select * from goods_detail where detail_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, detail_id);
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

	@Override
	public List<Goods_detail> selectAllGoods_detail(Connection conn) throws Exception {
		List<Goods_detail> list = new ArrayList<Goods_detail>();
		Goods_detail g = null;
		String sql = "select * from goods_detail";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			g = new Goods_detail();
			g.setDetail_id(rs.getInt("detail_id"));
			g.setGoods_id(rs.getInt("goods_id"));
			g.setFirst_picture(rs.getString("first_picture"));
			g.setSecond_picture(rs.getString("second_picture"));
			g.setThried_picture(rs.getString("thried_picture"));
			g.setDetails_picture(rs.getString("details_picture"));
			list.add(g);
		}
		
		return list;
	}

}
