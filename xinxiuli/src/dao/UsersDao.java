package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Users;


public interface UsersDao {
	public boolean insertUsers(Users users,Connection conn);
	public boolean updateUsers(Users users,Connection conn);
	public boolean deleteUsers(int users_id,Connection conn);
	public Users selectUsers(int users_id,Connection conn);
	public List<Users> selectAllUsers(Connection conn);
}
