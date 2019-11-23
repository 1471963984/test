package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.UsersDao;
import pojo.Users;

public class UsersDaoImpl implements UsersDao{

	@Override
	public boolean insertUsers(Users users, Connection conn) {
		boolean flag = false;
		String sql = "insert into users(users_id,account_num,users_name,users_nickname,users_addr,users_email,users_phone) values (null,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, users.getAccount_num());
			ps.setString(2, users.getUsers_name());
			ps.setString(3, users.getUsers_nickname());
			ps.setString(4, users.getUsers_addr());
			ps.setString(5, users.getUsers_email());
			ps.setString(6, users.getUsers_phone());
			if(ps.executeUpdate()>0) {
				flag = true;
				return flag;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean updateUsers(Users users, Connection conn) {
		boolean flag = false;
		String sql = "update users set account_num=?,users_name=?,users_nickname=?,users_addr=?,users_email=?,users_phone=? where users_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, users.getAccount_num());
			ps.setString(2, users.getUsers_name());
			ps.setString(3, users.getUsers_nickname());
			ps.setString(4, users.getUsers_addr());
			ps.setString(5, users.getUsers_email());
			ps.setString(6, users.getUsers_phone());
			ps.setInt(7, users.getUsers_id());
			if(ps.executeUpdate()>0) {
				flag = true;
				return flag;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return flag;
	}

	@Override
	public boolean deleteUsers(int users_id, Connection conn) {
		boolean flag = false;
		String sql = "delete from users where users_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, users_id);
			if(ps.executeUpdate()>0) {
				flag = true;
				return flag;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Users selectUsers(int users_id, Connection conn) {
		String sql = "select * from users where users_id=?";
		Users u = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, users_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u = new Users();
				u.setUsers_id(rs.getInt("users_id"));
				u.setAccount_num(rs.getString("account_num"));
				u.setUsers_name(rs.getString("users_name"));
				u.setUsers_nickname(rs.getString("users_nickname"));
				u.setUsers_addr(rs.getString("users_addr"));
				u.setUsers_email(rs.getString("users_email"));
				u.setUsers_phone(rs.getString("users_phone"));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<Users> selectAllUsers(Connection conn) {
		List<Users> list = new ArrayList<Users>();
		String sql = "select * from users";
		Users u = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new Users();
				u.setUsers_id(rs.getInt("users_id"));
				u.setAccount_num(rs.getString("account_num"));
				u.setUsers_name(rs.getString("users_name"));
				u.setUsers_nickname(rs.getString("users_nickname"));
				u.setUsers_addr(rs.getString("users_addr"));
				u.setUsers_email(rs.getString("users_email"));
				u.setUsers_phone(rs.getString("users_phone"));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
