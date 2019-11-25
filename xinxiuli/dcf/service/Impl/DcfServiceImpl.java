package service.Impl;

import java.sql.Connection;

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
		 Goods_color color=new Goods_color();
		 Goods_size size=new Goods_size();
		 ShowOneGoods sog=new ShowOneGoods();
		 GoodsDao gd=new GoodsDaoImpl();
		 Goods_colorDao gcd=new Goods_colorDaoImpl();
		 Goods_sizeDao gsd=new Goods_sizeDaoImpl();
		 try {
			conn.setAutoCommit(false);
			goods=gd.selectGoods(goodsnum, conn);
			color=gcd.selectGoods_colorOne(goods.getGoods_id(),goods.getGoods_color_num(), conn);
			size=gsd.selectGoods_sizeOne(goods.getGoods_id(),goods.getGoods_color_num(), goods.getGoods_size_num(), conn);
//			查询所有表封装需要的数据
			sog.setGoods_id(goods.getGoods_id());
			sog.setDivied_num(goods.getDivied_num());
			sog.setGoods_desc(goods.getGoods_desc());
			sog.setGoods_price(goods.getGoods_price());
			sog.setGoods_name(goods.getGoods_name());
			sog.setGoods_star(goods.getGoods_star());
			sog.setGoods_color_num(goods.getGoods_color_num());
			sog.setGoods_size_num(goods.getGoods_size_num());
			sog.setGoods_picture(goods.getGoods_picture());
			
			sog.setColor_name(color.getColor_name());
			sog.setGoods_delpicture(color.getGoods_delpicture());
			
			sog.setSize_name(size.getSize_name());
			sog.setSize_picture(size.getSize_picture());
			sog.setGoods_remain(size.getGoods_remain());
			conn.commit();
			return sog;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelp.closeConnection(conn);
		}
	   return sog;
	}

}
