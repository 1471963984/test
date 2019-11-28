package serviceImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

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
import service.ShowCartService;

public class ShowCartServiceImpl implements ShowCartService{

	@Override
	public List<Goods> selectAllMygoods(String account_num) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=DbHelp.getConnection();
		//通过账号获得cart-num
		List<Goods> list = new ArrayList<Goods>();
		AccountDao ad = new AccountDaoImpl();
		Account account = ad.selectAccount(account_num, conn);
		CartDao cd = new CartDaoImpl();
//		System.out.println("购物车"+account);//成功
		Cart ct = cd.selectCart(account.getCart_num(), conn);
		//通过购物车获取goods_num
		String goods_num = ct.getGoods_id();
		System.out.println(goods_num);
		String[] str = goods_num.split(",");
		System.out.println(str.length);
		GoodsDao gd = new GoodsDaoImpl();
		for (int i = 0; i < str.length; i++) {
			//通过goods_num找到唯一对应的商品
			Goods goods = gd.selectGoods(Integer.parseInt(str[i]),conn);
			list.add(goods);
		}
		
		return list;
	}


}
