package serviceImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import dao.AccountDao;
import dao.CartDao;
import dao.GoodsDao;
import dao.Goods_colorDao;
import dao.Goods_sizeDao;
import dao.impl.AccountDaoImpl;
import dao.impl.CartDaoImpl;
import dao.impl.GoodsDaoImpl;
import dao.impl.Goods_colorDaoImpl;
import dao.impl.Goods_sizeDaoImpl;
import db.DbHelp;
import dto.ShowMyCart;
import pojo.Account;
import pojo.Cart;
import pojo.Goods;
import pojo.Goods_color;
import pojo.Goods_size;
import service.ShowCartService;

public class ShowCartServiceImpl implements ShowCartService{

	@Override
	public List<ShowMyCart> selectAllMygoods(String account_num) throws Exception {
		Connection conn=DbHelp.getConnection();
		//通过账号获得cart-num
		AccountDao ad = new AccountDaoImpl();
		Account account = ad.selectAccount(account_num, conn);
		CartDao cd = new CartDaoImpl();
//		System.out.println("购物车"+account);//成功
		Cart ct = cd.selectCart(account.getCart_num(), conn);
		//通过购物车获取goods_num
		String goods_num = ct.getGoods_id();
		String[] str = goods_num.split(",");
		GoodsDao gd = new GoodsDaoImpl();
		//准备存dto的集合
		List<ShowMyCart> list = new ArrayList<ShowMyCart>();
		//查询对应商品并封装成dto
		Goods_colorDao cds = new Goods_colorDaoImpl();
		Goods_sizeDao sd = new Goods_sizeDaoImpl();
		for (int i = 0; i < str.length; i++) {
			//通过goods_num找到唯一对应的商品
			if(!"".equals(str[i])) {
				Goods g = gd.selectGoods(Integer.parseInt(str[i]),conn);
				ShowMyCart s = new ShowMyCart();
				if(g!=null) {
					s.setGoods_img(g.getGoods_picture());
					s.setGoods_desc(g.getGoods_desc());
					s.setGoods_name(g.getGoods_name());
					s.setGoods_id(g.getGoods_id());
					//颜色和尺寸还要查
					Goods_color color = cds.selectGoods_colorOne(g.getGoods_id(),g.getGoods_color_num(), conn);
					s.setGoods_color(color.getColor_name());
					Goods_size size = sd.selectGoods_sizeOne(g.getGoods_id(), g.getGoods_color_num(), g.getGoods_size_num(), conn);
					s.setGoods_size(size.getSize_name());
					s.setGoods_price(g.getGoods_price());
					s.setGoods_num(g.getGoods_num());
				}
				list.add(s);
			}
		}
		return list;
	}


}
