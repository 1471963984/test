package service.Impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.GoodsDao;
import dao.Goods_colorDao;
import dao.Goods_sizeDao;
import dao.impl.GoodsDaoImpl;
import dao.impl.Goods_colorDaoImpl;
import dao.impl.Goods_sizeDaoImpl;
import db.DbHelp;
import dto.ShowOneGoods;
import pojo.Goods;
import pojo.Goods_color;
import pojo.Goods_size;
import service.DcfService;

public class DcfServiceImpl implements DcfService{
	@Override
	public ShowOneGoods show(int goodsnum) {
		 Connection conn=DbHelp.getConnection();
		 Goods goods=new Goods();
		 
		 List<Goods_color> listcolor=new ArrayList<Goods_color>();
		 
		 List<Goods_size> lsize=new ArrayList<>();
		 
		 ShowOneGoods sog=new ShowOneGoods();
		 GoodsDao gd=new GoodsDaoImpl();
		 Goods_colorDao gcd=new Goods_colorDaoImpl();
		 Goods_sizeDao gsd=new Goods_sizeDaoImpl();
		 try {
			conn.setAutoCommit(false);
			goods=gd.selectGoods(goodsnum, conn);
			listcolor=gcd.queryGoods_color(goods.getGoods_id(), conn);
			lsize=gsd.querysGoods_size(goods.getGoods_id(), conn);
			sog.setGoods_id(goods.getGoods_id());
			sog.setDivied_num(goods.getDivied_num());
			sog.setGoods_desc(goods.getGoods_desc());
			sog.setGoods_price(goods.getGoods_price());
			sog.setGoods_name(goods.getGoods_name());
			sog.setGoods_star(goods.getGoods_star());
			sog.setGoods_color_num(goods.getGoods_color_num());
			sog.setGoods_size_num(goods.getGoods_size_num());
			sog.setGoods_picture(goods.getGoods_picture());
//			
			sog.setL(listcolor);
			sog.setLsize(lsize);
	
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelp.closeConnection(conn);
		}
	   return sog;
	}

}
