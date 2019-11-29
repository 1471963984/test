package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Users;

public interface UsersZiLiaoDao extends UsersDao{
	public List<Users> selectAllUsersByAccount_num(String account_num,Connection conn) throws Exception;
	
}
