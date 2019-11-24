package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.First_contentDao;
import db.DbHelp;
import pojo.First_content;

public class First_contentDaoImpl implements First_contentDao{

	@Override
	public boolean insertFirst_content(First_content first_content, Connection conn) {

		boolean flag = false;
		String sql = "insert into first_content(first_num,first_name) values (null,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, first_content.getFirst_name());
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
	public boolean updateFirst_content(First_content first_content, Connection conn) {
		boolean flag = false;
		String sql = "update first_content set first_name=? where first_num=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, first_content.getFirst_name());
			ps.setInt(2, first_content.getFirst_num());
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
	public List<First_content> selectAllFirst_content(Connection conn) {
		boolean flag = false;
		List<First_content> list = new ArrayList<First_content>();
		String sql = "select * from first_content";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				First_content f = new First_content();
				f.setFirst_name(rs.getString("first_name"));
				f.setFirst_num(rs.getInt("first_num"));
				list.add(f);
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

	@Override
	public boolean deleteFirst_content(int first_num, Connection conn) {
		boolean flag = false;
		String sql = "delete from first_content where first_num=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, first_num);
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
	public First_content selectFirst_content(int first_num, Connection conn) {
		First_content f = null;
		String sql = "select * from first_content where first_num=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				f = new First_content();
				f.setFirst_name(rs.getString("first_name"));
				f.setFirst_num(rs.getInt("first_num"));
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
		return f;
	}

}
