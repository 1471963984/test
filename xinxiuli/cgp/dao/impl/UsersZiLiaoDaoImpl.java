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
	public Users selectAllUsersByAccount_num(String account_num, Connection conn) throws Exception {
		String sql = "select * from users where account_num=?";
		Users u=new Users();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, account_num);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			u.setUsers_id(rs.getInt("users_id"));
			u.setAccount_num(rs.getString("account_num"));
			u.setUsers_name(rs.getString("users_name"));
			u.setUsers_nickname(rs.getString("users_nickname"));
			u.setUsers_addr(rs.getString("users_addr"));
			u.setUsers_email(rs.getString("users_email"));
			u.setUsers_phone(rs.getString("users_phone"));
		}
		return u;
	}
	
	@Override
	public boolean addAddres(Users users,Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update users set account_num=?,users_name=?,users_nickname=?,users_addr=?,users_email=?,users_phone=? where users_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);	
		ps.setString(1,users.getAccount_num());
		ps.setString(2, users.getUsers_name());
		ps.setString(3, users.getUsers_nickname());
		ps.setString(4, users.getUsers_addr());
		ps.setString(5, users.getUsers_email());
		ps.setString(6, users.getUsers_phone());
		ps.setInt(7, users.getUsers_id());
		if(ps.executeUpdate()>0) {
			flag = true;
		}		
		return flag;

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
