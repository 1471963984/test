package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Account;

public interface AccountDao {
	public boolean insertAccount(Account account,Connection conn);
	public boolean updateAccount(Account account,Connection conn);
	public boolean deleteAccount(String account_id,Connection conn);
	public Account selectAccount(String account_id,Connection conn);
	public List<Account> selectAllAccount(Connection conn);
}
