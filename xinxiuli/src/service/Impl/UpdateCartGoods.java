package service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AccountDao;
import dao.CartDao;
import dao.GoodsDao;
import dao.impl.AccountDaoImpl;
import dao.impl.CartDaoImpl;
import dao.impl.GoodsDaoImpl;
import db.DbHelp;
import pojo.Account;
import pojo.Cart;
import pojo.Goods;

public class UpdateCartGoods implements service.UpdateCartGoods{

	@Override
	public List<Goods> updateCartGoods(String account_num, int goods_id) {
		CartDao dao = new CartDaoImpl();
		AccountDao daoa = new AccountDaoImpl();
		Connection conn = DbHelp.getConnection();
		List<Goods> list = new ArrayList<Goods>();
		GoodsDao daos = new GoodsDaoImpl();
		boolean flag = false;
		try {
			Account account = daoa.selectAccount(account_num, conn);
			String cart_num = account.getCart_num();
			Cart c = dao.selectCart(cart_num, conn);
			String goods_num = c.getGoods_id(); 
			String good_id = String.valueOf(goods_id);
			String[] s = goods_num.split(",");
			for (int i = 0; i < s.length; i++) {
				if(good_id.equals(s[i])) {
					goods_num = goods_num.replace(good_id+",", "");
				}
			}
			flag = dao.updateCartById(cart_num, goods_num, conn);
			if(flag==true) {
				if(goods_num!=null) {
					String[] s1 = goods_num.split(",");
					for (int i = 0; i < s1.length; i++) {
						int goods_ids = Integer.parseInt(s1[i]);
						Goods g = daos.selectGoods(goods_ids, conn);
						list.add(g);
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
