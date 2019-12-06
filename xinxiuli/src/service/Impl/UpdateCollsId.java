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

public class UpdateCollsId implements service.UpdateCollsId{

	@Override
	public List<Goods> updateCollsId(String account_num,int goods_id) {
		AccountDao dao = new AccountDaoImpl();
		Connection conn = DbHelp.getConnection();
		List<Goods> list = new ArrayList<Goods>();
		GoodsDao daos = new GoodsDaoImpl();
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
			if(flag==true) {
				if(coll_goods!=null) {
					String[] s1 = coll_goods.split(",");
					for (int i = 0; i < s1.length; i++) {
						if(!"".equals(s1[i])) {
							int goods_ids = Integer.parseInt(s1[i]);
							Goods g = daos.selectGoodsById(goods_ids, conn);
							list.add(g);
						}
					}
				}
			}
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
		return list;
	}

}
