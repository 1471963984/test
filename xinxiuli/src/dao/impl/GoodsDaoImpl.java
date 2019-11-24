package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GoodsDao;
import db.DbHelp;
import pojo.Goods;

public class GoodsDaoImpl implements GoodsDao{

	@Override
	public boolean insertGoods(Goods goods, Connection conn) {
		boolean flag = false;
		String sql = "insert into goods(goods_id,divied_num,goods_desc,goods_price,goods_name,goods_star,goods_color_num,goods_size_num,goods_picture) values(null,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, goods.getDivied_num());
			ps.setString(2, goods.getGoods_desc());
			ps.setDouble(3, goods.getGoods_price());
			ps.setString(4, goods.getGoods_name());
			ps.setInt(5, goods.getGoods_star());
			ps.setInt(6, goods.getGoods_color_num());
			ps.setInt(7, goods.getGoods_size_num());
			ps.setString(8, goods.getGoods_picture());
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
	public boolean updateGoods(Goods goods, Connection conn) {
		boolean flag = false;
		String sql = "update goods set divied_num=?,goods_desc=?,goods_price=?,goods_name=?,goods_star=?,goods_color_num=?,goods_size_num=?,goods_picture=? where goods_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, goods.getDivied_num());
			ps.setString(2, goods.getGoods_desc());
			ps.setDouble(3, goods.getGoods_price());
			ps.setString(4, goods.getGoods_name());
			ps.setInt(5, goods.getGoods_star());
			ps.setInt(6, goods.getGoods_color_num());
			ps.setInt(7, goods.getGoods_size_num());
			ps.setString(8, goods.getGoods_picture());
			ps.setInt(9, goods.getGoods_id());
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
	public boolean deleteGoods(int goods_id, Connection conn) {
		boolean flag = false;
		String sql = "delete from goods where goods_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, goods_id);
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
	public Goods selectGoods(int goods_id, Connection conn) {
		Goods g = null;
		String sql = "select * from goods where goods_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, goods_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				g = new Goods();
				g.setGoods_id(rs.getInt("goods_id"));
				g.setDivied_num(rs.getInt("divied_num"));
				g.setGoods_desc(rs.getString("goods_desc"));
				g.setGoods_price(rs.getDouble("goods_price"));
				g.setGoods_name(rs.getString("goods_name"));
				g.setGoods_star(rs.getInt("goods_star"));
				g.setGoods_color_num(rs.getInt("goods_color_num"));
				g.setGoods_size_num(rs.getInt("goods_size_num"));
				g.setGoods_picture(rs.getString("goods_picture"));
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
	public List<Goods> selectAllGoods(Connection conn) {
		List<Goods> list = new ArrayList<Goods>();
		String sql = "select * from goods";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Goods g = new Goods();
				g.setGoods_id(rs.getInt("goods_id"));
				g.setDivied_num(rs.getInt("divied_num"));
				g.setGoods_desc(rs.getString("goods_desc"));
				g.setGoods_price(rs.getDouble("goods_price"));
				g.setGoods_name(rs.getString("goods_name"));
				g.setGoods_star(rs.getInt("goods_star"));
				g.setGoods_color_num(rs.getInt("goods_color_num"));
				g.setGoods_size_num(rs.getInt("goods_size_num"));
				g.setGoods_picture(rs.getString("goods_picture"));
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
