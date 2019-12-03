package serviceImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.GoodsDao;
import dao.Goods_colorDao;
import dao.Goods_sizeDao;
import dao.UsersZiLiaoDao;
import dao.impl.GoodsDaoImpl;
import dao.impl.Goods_colorDaoImpl;
import dao.impl.Goods_sizeDaoImpl;
import dao.impl.UsersZiLiaoDaoImpl;
import dto.Addrs;
import dto.CartGoods;
import dto.JieSuanShow;
import pojo.Goods;
import pojo.Goods_color;
import pojo.Goods_size;
import pojo.Users;
import service.JieSuanService;

public class JieSuanServiceImpl implements JieSuanService{

	@Override
	public List<Addrs> getMyAddrs(String account_num, Connection conn) {
		//查用户信息dao
		UsersZiLiaoDao uzd = new UsersZiLiaoDaoImpl();
		//准备存用户信息的集合
		List<Object> namelist = new ArrayList<Object>();
		List<Object> tellist = new ArrayList<Object>();
		List<Object> dizhilist = new ArrayList<Object>();
		List<Addrs> aslist = new ArrayList<Addrs>();
		Users user = null;
		if(account_num!=null){
			try {
				//通过账号获取用户信息
				user = uzd.selectUsersByAccount_num(account_num, conn);
				//拆分用户信息
				String[] name = user.getUsers_name().split(",");
				String[] tel = user.getUsers_phone().split(",");
				String[] dizhi = user.getUsers_addr().split(",");
				int len = name.length;
				//把地址封装成Addrs
				for (int i = 0; i < len; i++) {
					//把地址和商品分别封装成dto
					//地址
					Addrs as = new Addrs();
					as.setName(name[i]);
					as.setTel(tel[i]);
					as.setDizhi(dizhi[i]);
					aslist.add(as);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return aslist;
	}

	@Override
	public CartGoods getMyGoods(String account_num, int goods_num, Connection conn) throws Exception {
		List<CartGoods> cglist = new ArrayList<CartGoods>();
		GoodsDao gd = new GoodsDaoImpl();
		Goods_colorDao cds = new Goods_colorDaoImpl();
		Goods_sizeDao sd = new Goods_sizeDaoImpl();
		//商品
		CartGoods cg = null;
		if(account_num!=null){
			Goods g = gd.selectGoods(goods_num,conn);
			cg = new CartGoods();
			cg.setGoods_img(g.getGoods_picture());
			cg.setGoods_desc(g.getGoods_desc());
			cg.setGoods_name(g.getGoods_name());
			//颜色和尺寸还要查
			Goods_color color = cds.selectGoods_colorOne(g.getGoods_id(),g.getGoods_color_num(), conn);
			cg.setGoods_color(color.getColor_name());
			Goods_size size = sd.selectGoods_sizeOne(g.getGoods_id(), g.getGoods_color_num(), g.getGoods_size_num(), conn);
			cg.setGoods_size(size.getSize_name());
			cg.setGoods_price(g.getGoods_price());
			cg.setGoods_num(g.getGoods_num());
		}
		return cg;
	}
	
	

}
