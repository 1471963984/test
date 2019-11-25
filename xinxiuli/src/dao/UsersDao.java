package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Users;


public interface UsersDao {
	public boolean insertUsers(Users users,Connection conn) throws Exception;
	public boolean updateUsers(Users users,Connection conn) throws Exception;
	public boolean deleteUsers(int users_id,Connection conn) throws Exception;
	public Users selectUsers(int users_id,Connection conn) throws Exception;
	public List<Users> selectAllUsers(Connection conn) throws Exception;
}
