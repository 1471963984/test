package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Goods_sizeDao;
import db.DbHelp;
import pojo.Goods_size;

public class Goods_sizeDaoImpl implements Goods_sizeDao{

	@Override
	public boolean insertGoods_size(Goods_size goods_size, Connection conn) {
		boolean flag = false;
		String sql = "insert into goods_size(sid,goods_id,color_num,size_num,size_name,size_picture,goods_remain) values(null,?,?,?,?,?,?)";
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null&&!conn.isClosed()) {
					DbHelp.closeConnection(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public boolean updateGoods_size(Goods_size goods_size, Connection conn) {
		boolean flag = false;
		String sql = "update goods_size set goods_id=?,color_num=?,size_num=?,size_name=?,size_picture=?,goods_remain=? where sid=?";
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null&&!conn.isClosed()) {
					DbHelp.closeConnection(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	@Override
	public boolean deleteGoods_size(int sid, Connection conn) {
		boolean flag = false;
		String sql = "delete from goods_size where sid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);
			if(ps.executeUpdate()>0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null&&!conn.isClosed()) {
					DbHelp.closeConnection(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public Goods_size selectGoods_size(int sid, Connection conn) {
		String sql = "select * from goods_size where sid=?";
		Goods_size g = null;
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null&&!conn.isClosed()) {
					DbHelp.closeConnection(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return g;
	}

	@Override
	public List<Goods_size> selectAllGoods_size(Connection conn) {
		List<Goods_size> list= new ArrayList<Goods_size>();
		Goods_size g = null;
		String sql = "select * from goods_size";
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null&&!conn.isClosed()) {
					DbHelp.closeConnection(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}
