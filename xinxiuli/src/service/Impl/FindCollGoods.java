package service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AccountDao;
import dao.GoodsDao;
import dao.impl.AccountDaoImpl;
import dao.impl.GoodsDaoImpl;
import db.DbHelp;
import pojo.Account;
import pojo.Goods;

public class FindCollGoods implements service.FindCollGoods{

	@Override
	public List<Goods> findCollGoods(String account_num) {
		Connection conn = DbHelp.getConnection();
		AccountDao dao = new AccountDaoImpl();
		GoodsDao daos = new GoodsDaoImpl();
		List<Goods> list = new ArrayList<Goods>();
		try {
			Account account = dao.selectAccount(account_num, conn);
			if(account!=null) {
				String cool_goods = account.getColl_goods();
				if(cool_goods!=null) {
					String[] s = cool_goods.split(",");
					for (int i = 0; i < s.length; i++) {
						if(!"".equals(s[i])&&s[i]!=null) {
							int goods_id = Integer.parseInt(s[i]);
							Goods g = daos.selectGoodsById(goods_id, conn);
							list.add(g);
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null&&!conn.isClosed()) {
					DbHelp.closeConnection(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}
