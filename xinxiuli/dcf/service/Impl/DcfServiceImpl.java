package service.Impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.AccountDao;
import dao.DcfAddCard;
import dao.DcfGoodsDao;
import dao.DcfGoods_detailDao;
import dao.GoodsDao;
import dao.Goods_colorDao;
import dao.Goods_sizeDao;
import dao.PersonCartDao;
import dao.impl.AccountDaoImpl;
import dao.impl.DcfAddCardDaoImpl;
import dao.impl.DcfGoodsDaoImpl;
import dao.impl.DcfGoods_detailDaoImpl;
import dao.impl.GoodsDaoImpl;
import dao.impl.Goods_colorDaoImpl;
import dao.impl.Goods_sizeDaoImpl;
import dao.impl.PersonCartDaoImpl;
import db.DbHelp;
import dto.ShowOneGoods;
import pojo.Account;
import pojo.Goods;
import pojo.Goods_color;
import pojo.Goods_detail;
import pojo.Goods_size;
import service.DcfService;

public class DcfServiceImpl implements DcfService{
	@Override
	public ShowOneGoods show(int goodsnum) {
		 Connection conn=DbHelp.getConnection();
		 Goods goods=new Goods();
		 
		 List<Goods_color> listcolor=new ArrayList<Goods_color>();
		 
		 List<Goods_size> lsize=new ArrayList<>();
//		 细节对象
		 Goods_detail detail=new Goods_detail();
		 ShowOneGoods sog=new ShowOneGoods();
		 GoodsDao gd=new GoodsDaoImpl();
		 Goods_colorDao gcd=new Goods_colorDaoImpl();
		 Goods_sizeDao gsd=new Goods_sizeDaoImpl();
		 DcfGoods_detailDao ddd=new DcfGoods_detailDaoImpl();
		 try {
			conn.setAutoCommit(false);
			goods=gd.selectGoods(goodsnum, conn);
			listcolor=gcd.queryGoods_color(goods.getGoods_id(), conn);
			lsize=gsd.querysGoods_size(goods.getGoods_id(), conn);
			detail=ddd.queryPhoto(goods.getGoods_id(),conn);
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
//	        存大图
			sog.setDetail(detail);
//	    存细节图
			sog.setDetailphoto(detail.getDetails_picture().split(";"));
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelp.closeConnection(conn);
		}
	   return sog;
	}
//根据3个字段查询出goods主键
	public int selectNumber(int gid, int cid, int sid,String account_num) {
		 Connection conn=DbHelp.getConnection();
		 DcfGoodsDao dgd=new DcfGoodsDaoImpl();
		 PersonCartDao pcd=new PersonCartDaoImpl();
		 AccountDao ad=new AccountDaoImpl();
		 DcfAddCard dac=new DcfAddCardDaoImpl();
		 int mid=0;
		 boolean bb=false;
		 try {
			conn.setAutoCommit(false);
            mid=dgd.selectNumber(gid, cid, sid, conn);
            String str=pcd.selectAllMyGoods(account_num, conn);
            String st=str+String.valueOf(mid)+",";
            Account accou=ad.selectAccount(account_num, conn);             
            dac.addGoodsMyCard(accou.getCart_num(), st, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelp.closeConnection(conn);
		}
	   return mid;
	}

}
