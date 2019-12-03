package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dao.UpdateKucunDao;
import pojo.Goods_size;

public class UpdateKucunDaoImpl implements UpdateKucunDao{
	@Override
	public boolean insertGoods_size(Goods_size goods_size, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGoods_size(Goods_size goods_size, Connection conn) throws Exception {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Goods_size selectGoods_size(int sid, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goods_size selectGoods_sizeOne(int goodsid, int colornum, int sizenum, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods_size> queryGoods_size(int goodsid, int colornum, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods_size> querysGoods_size(int goodsid, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods_size> selectAllGoods_size(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goods_size selectGoods_sizeByAllInfo(int goods_id, int color_num, int size_num, Connection conn)
			throws Exception {
		String sql = "select * from goods_size where goods_id=? and color_num=? and size_num=?";
		Goods_size g = null;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, goods_id);
			ps.setInt(2, color_num);
			ps.setInt(3, size_num);
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

}
