package service.FirstContentImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.AccountDao;
import dao.GoodsDao;
import dao.impl.AccountDaoImpl;
import dao.impl.GoodsDaoImpl;
import db.DbHelp;
import pojo.Goods;

public class SercherCartInfo implements service.SercherCartInfo{

	@Override
	public List<Goods> sercherCartInfo(String account_num){
		Connection conn = DbHelp.getConnection();
		AccountDao dao = new AccountDaoImpl();
		GoodsDao daos = new GoodsDaoImpl();
		List<Goods> list = new ArrayList<Goods>();
		String goods_id = null;
		try {
			goods_id = dao.selectCartGoods(account_num, conn);
			if(goods_id!=null) {
				String[] s = goods_id.split(",");
				for (int i = 0; i < s.length; i++) {
					int goods_num = Integer.parseInt(s[i]);
					Goods g = daos.selectGoods(goods_num, conn);
					list.add(g);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
