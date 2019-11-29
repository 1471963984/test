package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.UsersZiLiaoDao;
import pojo.Users;

public class UsersZiLiaoDaoImpl implements UsersZiLiaoDao{
	
	@Override
	public List<Users> selectAllUsersByAccount_num(String account_num, Connection conn) throws Exception {
//		String sql = "select * from users where account_num=?";
//		Users u = null;
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, account_num);
//		ResultSet rs = ps.executeQuery();
//		if(rs.next()) {
//			u = new Users();
//			u.setUsers_id(rs.getInt("users_id"));
//			u.setAccount_num(rs.getString("account_num"));
//			u.setUsers_name(rs.getString("users_name"));
//			u.setUsers_nickname(rs.getString("users_nickname"));
//			u.setUsers_addr(rs.getString("users_addr"));
//			u.setUsers_email(rs.getString("users_email"));
//			u.setUsers_phone(rs.getString("users_phone"));
//		}
		String sql = "select * from users where account_num=?";
		List<Users> list = new ArrayList<Users>();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, account_num);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Users u = new Users();
			u.setUsers_id(rs.getInt("users_id"));
			u.setAccount_num(rs.getString("account_num"));
			u.setUsers_name(rs.getString("users_name"));
			u.setUsers_nickname(rs.getString("users_nickname"));
			u.setUsers_addr(rs.getString("users_addr"));
			u.setUsers_email(rs.getString("users_email"));
			u.setUsers_phone(rs.getString("users_phone"));
			list.add(u);
		}
		return list;
	}

	@Override
	public boolean insertUsers(Users users, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUsers(Users users, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUsers(int users_id, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Users selectUsers(int users_id, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> selectAllUsers(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
