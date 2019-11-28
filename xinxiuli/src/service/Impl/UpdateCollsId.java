package service.Impl;

import java.sql.Connection;
import java.sql.SQLException;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import db.DbHelp;
import pojo.Account;

public class UpdateCollsId implements service.UpdateCollsId{

	@Override
	public boolean updateCollsId(String account_num,int goods_id) {
		AccountDao dao = new AccountDaoImpl();
		Connection conn = DbHelp.getConnection();
		boolean flag = false;
		try {
			Account account = dao.selectAccount(account_num, conn);
			String coll_goods = account.getColl_goods();
			String good_id = String.valueOf(goods_id);
			String[] s = coll_goods.split(",");
			for (int i = 0; i < s.length; i++) {
				if(good_id.equals(s[i])) {
					coll_goods = coll_goods.replace(good_id+",", "");
				}
			}
			flag = dao.updateAccount(account_num, coll_goods, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(conn!=null&&!conn.isClosed()) {
					DbHelp.closeConnection(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

}
