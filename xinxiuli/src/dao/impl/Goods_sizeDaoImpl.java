package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Goods_sizeDao;
import pojo.Goods_size;

public class Goods_sizeDaoImpl implements Goods_sizeDao{

	@Override
	public boolean insertGoods_size(Goods_size goods_size, Connection conn) throws Exception{
		boolean flag = false;
		String sql = "insert into goods_size(sid,goods_id,color_num,size_num,size_name,size_picture,goods_remain) values(null,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, goods_size.getGoods_id());
			ps.setInt(2, goods_size.getColor_num());
			ps.setInt(3, goods_size.getSize_num());
			ps.setString(4, goods_size.getSize_name());
			ps.setString(5, goods_size.getSize_picture());
			ps.setInt(6, goods_size.getGoods_remain());
			if(ps.executeUpdate()>0) {
				flag = true;
			}
		return flag;
	}

	@Override
	public boolean updateGoods_size(Goods_size goods_size, Connection conn) throws Exception{
		boolean flag = false;
		String sql = "update goods_size set goods_id=?,color_num=?,size_num=?,size_name=?,size_picture=?,goods_remain=? where sid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, goods_size.getGoods_id());
			ps.setInt(2, goods_size.getColor_num());
			ps.setInt(3, goods_size.getSize_num());
			ps.setString(4, goods_size.getSize_name());
			ps.setString(5, goods_size.getSize_picture());
			ps.setInt(6, goods_size.getGoods_remain());
			ps.setInt(7, goods_size.getSid());
			if(ps.executeUpdate()>0) {
				flag = true;
			}
		return flag;
	}

	@Override
	public boolean deleteGoods_size(int sid, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from goods_size where sid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);
			if(ps.executeUpdate()>0) {
				flag = true;
			}
		return flag;
	}

	@Override
	public Goods_size selectGoods_size(int sid, Connection conn) throws Exception{
		String sql = "select * from goods_size where sid=?";
		Goods_size g = null;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				g = new Goods_size();
				g.setSid(rs.getInt("sid"));
				g.setGoods_id(rs.getInt("goods_id"));
				g.setColor_num(rs.getInt("color_num"));
				g.setSize_num(rs.getInt("size_num"));
				g.setSize_name(rs.getString("size_name"));
				g.setSize_picture(rs.getString("size_picture"));
				g.setGoods_remain(rs.getInt("goods_remain"));
			}
		return g;
	}

	@Override
	public List<Goods_size> selectAllGoods_size(Connection conn) throws Exception{
		List<Goods_size> list= new ArrayList<Goods_size>();
		Goods_size g = null;
		String sql = "select * from goods_size";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				g = new Goods_size();
				g.setSid(rs.getInt("sid"));
				g.setGoods_id(rs.getInt("goods_id"));
				g.setColor_num(rs.getInt("color_num"));
				g.setSize_num(rs.getInt("size_num"));
				g.setSize_name(rs.getString("size_name"));
				g.setSize_picture(rs.getString("size_picture"));
				g.setGoods_remain(rs.getInt("goods_remain"));
				list.add(g);
			}
		return list;
	}
	public Goods_size selectGoods_sizeOne(int goodsid,int colornum,int sizenum,Connection conn) throws Exception{
		String sql = "select * from goods_size where goods_id=? and color_num=? and size_num=?";
		Goods_size g = null;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, goodsid);
			ps.setInt(2, colornum);
			ps.setInt(3,sizenum);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				g = new Goods_size();
				g.setSid(rs.getInt("sid"));
				g.setGoods_id(rs.getInt("goods_id"));
				g.setColor_num(rs.getInt("color_num"));
				g.setSize_num(rs.getInt("size_num"));
				g.setSize_name(rs.getString("size_name"));
				g.setSize_picture(rs.getString("size_picture"));
				g.setGoods_remain(rs.getInt("goods_remain"));
			}
		return g;
	}
	public List<Goods_size> queryGoods_size(int goodsid,int colornum,Connection conn) throws Exception{
		List<Goods_size> list= new ArrayList<Goods_size>();
		String sql = "select * from goods_size where good_is=? and color_num=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, goodsid);
			ps.setInt(2, colornum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Goods_size g= new Goods_size();
				g.setSid(rs.getInt("sid"));
				g.setGoods_id(rs.getInt("goods_id"));
				g.setColor_num(rs.getInt("color_num"));
				g.setSize_num(rs.getInt("size_num"));
				g.setSize_name(rs.getString("size_name"));
				g.setSize_picture(rs.getString("size_picture"));
				g.setGoods_remain(rs.getInt("goods_remain"));
				list.add(g);
			}
		return list;
	}
	public List<Goods_size> querysGoods_size(int goodsid,Connection conn) throws Exception{
		List<Goods_size> list= new ArrayList<Goods_size>();
		String sql = "select * from goods_size where goods_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, goodsid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Goods_size g= new Goods_size();
				g.setSid(rs.getInt("sid"));
				g.setGoods_id(rs.getInt("goods_id"));
				g.setColor_num(rs.getInt("color_num"));
				g.setSize_num(rs.getInt("size_num"));
				g.setSize_name(rs.getString("size_name"));
				g.setSize_picture(rs.getString("size_picture"));
				g.setGoods_remain(rs.getInt("goods_remain"));
				list.add(g);
			}
		return list;
	}

}
