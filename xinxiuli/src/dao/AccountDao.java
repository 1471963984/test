package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Account;

public interface AccountDao {
	public boolean insertAccount(Account account,Connection conn) throws Exception;
	public boolean updateAccount(Account account,Connection conn) throws Exception;
	public boolean deleteAccount(String account_num,Connection conn) throws Exception;
	public Account selectAccount(String account_num,Connection conn) throws Exception;
	public List<Account> selectAllAccount(Connection conn) throws Exception;
	public String selectCartGoods(String account_num,Connection conn) throws Exception;
	public boolean updateAccount(String account_num,String coll_goods,Connection conn) throws Exception;
}
