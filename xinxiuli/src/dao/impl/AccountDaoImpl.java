package dao.impl;

import java.sql.Connection;
import java.util.List;
import dao.AccountDao;
import pojo.Account;

public class AccountDaoImpl implements AccountDao{

	@Override
	public boolean insertAccount(Account account, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAccount(Account account, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(String account_id, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account selectAccount(String account_id, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> selectAllAccount(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}



}
