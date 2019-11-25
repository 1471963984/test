package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Account;

public interface AccountDao {
	public boolean insertAccount(Account account,Connection conn) throws Exception;
	public boolean updateAccount(Account account,Connection conn) throws Exception;
	public boolean deleteAccount(String account_id,Connection conn) throws Exception;
	public Account selectAccount(String account_id,Connection conn) throws Exception;
	public List<Account> selectAllAccount(Connection conn) throws Exception;
}
