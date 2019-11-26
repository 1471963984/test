package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Second_contentDao;
import db.DbHelp;
import pojo.Second_content;

public class Second_contentDaoImpl implements Second_contentDao{

	@Override
	public boolean insertSecond_content(Second_content second_content, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into second_content(second_num,first_num,second_name,divied_num) values(null,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, second_content.getFirst_num());
		ps.setString(2, second_content.getSecond_name());
		ps.setInt(3, second_content.getDivied_num());
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public boolean updateSecond_content(Second_content second_content, Connection conn) throws Exception {
		boolean flag = true;
		String sql = "update second_content set first_num=?,second_name=?,divied_num=? where second_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, second_content.getFirst_num());
		ps.setString(2, second_content.getSecond_name());
		ps.setInt(3, second_content.getDivied_num());
		ps.setInt(4, second_content.getSecond_num());
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public boolean deleteSecond_content(int second_num, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from second_content where second_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, second_num);
		if(ps.executeUpdate()>0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public Second_content selectSecond_content(int second_num, Connection conn) throws Exception {
		String sql = "select * from second_content where second_num=?";
		Second_content s = null;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, second_num);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			s = new Second_content();
			s.setSecond_num(rs.getInt("second_num"));
			s.setFirst_num(rs.getInt("first_num"));
			s.setSecond_name(rs.getString("second_name"));
			s.setDivied_num(rs.getInt("divied_num"));
		}
		
		return s;
	}

	@Override
	public List<Second_content> selectAllSecond_content(Connection conn) throws Exception {
		List<Second_content> list = new ArrayList<Second_content>();
		String sql = "select * from second_content";
		Second_content s = null;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			s = new Second_content();
			s.setSecond_num(rs.getInt("second_num"));
			s.setFirst_num(rs.getInt("first_num"));
			s.setSecond_name(rs.getString("second_name"));
			s.setDivied_num(rs.getInt("divied_num"));
			list.add(s);
		}
		
		return list;
	}

}
