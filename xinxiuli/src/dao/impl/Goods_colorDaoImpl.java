package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Goods_colorDao;
import db.DbHelp;
import pojo.Goods_color;

public class Goods_colorDaoImpl implements Goods_colorDao{

	@Override
	public boolean insertGoods_color(Goods_color goods_color, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into goods_color(pid,goods_id,color_num,color_name,goods_delpicture) values(null,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, goods_color.getGoods_id());
		ps.setInt(2, goods_color.getColor_num());
		ps.setString(3, goods_color.getColor_name());
		ps.setString(4, goods_color.getGoods_delpicture());
		if(ps.executeUpdate()>0) {
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean updateGoods_color(Goods_color goods_color, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update goods_color set goods_id=?,color_num=?,color_name=?,goods_delpicture=? where pid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, goods_color.getGoods_id());
		ps.setInt(2, goods_color.getColor_num());
		ps.setString(3, goods_color.getColor_name());
		ps.setString(4, goods_color.getGoods_delpicture());
		ps.setInt(5, goods_color.getPid());
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public boolean deleteGoods_color(int pid, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from goods_color where pid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, pid);
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		return flag;
		
	}

	@Override
	public Goods_color selectGoods_color(int pid, Connection conn) throws Exception {
		Goods_color g = null;
		String sql = "select * from goods_color where pid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, pid);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			g = new Goods_color();
			g.setPid(rs.getInt("pid"));
			g.setGoods_id(rs.getInt("goods_id"));
			g.setColor_num(rs.getInt("color_num"));
			g.setColor_name(rs.getString("color_name"));
			g.setGoods_delpicture(rs.getString("goods_delpicture"));
		}	
		return g;
	}

	@Override
	public List<Goods_color> selectAllGoods_color(Connection conn) throws Exception {
		List<Goods_color> list = new ArrayList<Goods_color>();
		String sql = "select * from goods_color";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Goods_color g = new Goods_color();
			g.setPid(rs.getInt("pid"));
			g.setGoods_id(rs.getInt("goods_id"));
			g.setColor_num(rs.getInt("color_num"));
			g.setColor_name(rs.getString("color_name"));
			g.setGoods_delpicture(rs.getString("goods_delpicture"));
			list.add(g);
		}	
		return list;
	}
	public Goods_color selectGoods_colorOne(int goodid,int colornum,Connection conn) throws Exception{
		Goods_color g = null;
		String sql = "select * from goods_color where goods_id=? and color_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, goodid);
		ps.setInt(2, colornum);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			g = new Goods_color();
			g.setPid(rs.getInt("pid"));
			g.setGoods_id(rs.getInt("goods_id"));
			g.setColor_num(rs.getInt("color_num"));
			g.setColor_name(rs.getString("color_name"));
			g.setGoods_delpicture(rs.getString("goods_delpicture"));
		}	
		return g;
	}
//	查询一件商品多个颜色
	public List<Goods_color> queryGoods_color(int goodsid, Connection conn) throws Exception {
		List<Goods_color> l=new ArrayList<Goods_color>();
		String sql = "select * from goods_color where goods_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,goodsid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Goods_color g = new Goods_color();
			g.setPid(rs.getInt("pid"));
			g.setGoods_id(rs.getInt("goods_id"));
			g.setColor_num(rs.getInt("color_num"));
			g.setColor_name(rs.getString("color_name"));
			g.setGoods_delpicture(rs.getString("goods_delpicture"));
			l.add(g);
		}	
		return l;
	}

}
