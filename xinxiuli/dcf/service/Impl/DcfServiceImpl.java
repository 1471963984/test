package service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.AccountDao;
import dao.DcfAddCardDao;
import dao.DcfAddCollDao;
import dao.DcfGoodsDao;
import dao.DcfGoods_detailDao;
import dao.GoodsDao;
import dao.Goods_colorDao;
import dao.Goods_sizeDao;
import dao.PersonCartDao;
import dao.impl.AccountDaoImpl;
import dao.impl.DcfAddCardDaoImpl;
import dao.impl.DcfAddCollDaoImpl;
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
	private static final Logger log = Logger.getLogger(DcfServiceImpl.class);
	@Override
	public ShowOneGoods show(int goodsnum,String accnum) {
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
//		 查询该商品是否被收藏
		 AccountDao ad=new AccountDaoImpl();
		 try {
			conn.setAutoCommit(false);
			goods=gd.selectGoods(goodsnum, conn);
			listcolor=gcd.queryGoods_color(goods.getGoods_id(), conn);
			lsize=gsd.querysGoods_size(goods.getGoods_id(), conn);
			detail=ddd.queryPhoto(goods.getGoods_id(),conn);
			sog.setGoods_num(goods.getGoods_num());
			sog.setGoods_id(goods.getGoods_id());
			sog.setDivied_num(goods.getDivied_num());
			sog.setGoods_desc(goods.getGoods_desc());
			String s=String.valueOf(goods.getGoods_price());
			sog.setGoods_price(Double.parseDouble(s));
			sog.setGoods_name(goods.getGoods_name());
			sog.setGoods_star(goods.getGoods_star());
			sog.setGoods_color_num(goods.getGoods_color_num());
			sog.setGoods_size_num(goods.getGoods_size_num());
//			颜色组图			
			sog.setGoods_picture(goods.getGoods_picture());
//			
			sog.setL(listcolor);
			sog.setLsize(lsize);
//	        存大图
			sog.setDetail(detail);
//	    存细节图
			sog.setDetailphoto(detail.getDetails_picture().split(";"));
		if(!accnum.equals("")) {
//			该商品是否被收藏
			Account ac=ad.selectAccount(accnum, conn);
			String mycoll=ac.getColl_goods();
			if(!"null".equals(mycoll)&&mycoll!=null) {
				String[] goodsid=ac.getColl_goods().split(",");
				for(int i=0;i<goodsid.length;i++) {
					if(goodsid[i].equals(String.valueOf(goods.getGoods_id()))) {
						sog.setIsColl("has");
						break;
					}
				}
			}else {
				ac.setColl_goods("");
				String old=ac.getColl_goods();
				String[] goodsid=old.split(",");
				for(int i=0;i<goodsid.length;i++) {
					if(goodsid[i].equals(String.valueOf(goods.getGoods_id()))) {
						sog.setIsColl("has");
						break;
					}
				}
			}
		}
			conn.commit();
		} catch (Exception e) {
			log.error(e);
		}finally {
			try {
				if(conn!=null&&!conn.isClosed()) {
					DbHelp.closeConnection(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
		}
	   return sog;
	}
//根据3个字段查询出goods主键
	public int selectNumber(int gid, int cid, int sid,String account_num,int num) {
		 Connection conn=DbHelp.getConnection();
		 DcfGoodsDao dgd=new DcfGoodsDaoImpl();
		 PersonCartDao pcd=new PersonCartDaoImpl();
		 AccountDao ad=new AccountDaoImpl();
		 DcfAddCardDao dac=new DcfAddCardDaoImpl();
		 int mid=0;
		 boolean bb=false;
		 try {
			conn.setAutoCommit(false);
            mid=dgd.selectNumber(gid, cid, sid, conn);
            String str=pcd.selectAllMyGoods(account_num, conn);
            StringBuffer sb=new StringBuffer();
            if(str!=null) {
	            sb.append(str);
	            for(int i=0;i<num;i++) { 
		           sb.append(String.valueOf(mid)+",");
	            }
	            Account accou=ad.selectAccount(account_num, conn);         
	        	dac.addGoodsMyCard(accou.getCart_num(), sb.toString(), conn);
            }else {
            	 str="";
                 sb.append(str);
 	            for(int i=0;i<num;i++) { 
 		           sb.append(String.valueOf(mid)+",");
 	            }
 	            Account accou=ad.selectAccount(account_num, conn);
 	        	dac.addGoodsMyCard(accou.getCart_num(), sb.toString(), conn);
            }
			conn.commit();
		} catch (Exception e) {
			log.error(e);
		}finally {
			try {
				if(conn!=null&&!conn.isClosed()) {
					DbHelp.closeConnection(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
		}
	   return mid;
	}
	public boolean addColl(String accnum,String goodsid){
		 Connection conn=DbHelp.getConnection();
		 boolean bb=false;
		 try {
			 DcfAddCollDao dad=new DcfAddCollDaoImpl();
			 AccountDao ad=new AccountDaoImpl();		
			  Account a=ad.selectAccount(accnum, conn);
//			  先判断是否已经收藏了该商品
			if(!accnum.equals("")) {
				if(a.getColl_goods()==null) {
//					防止数据库得到的是空字符串	
						a.setColl_goods("");
					}
				  String[] strs=a.getColl_goods().split(",");
				  if(strs.length>0) {
					  for(int i=0;i<strs.length;i++) {
						  if(!goodsid.equals(strs[i])) {
							  String ss=a.getColl_goods()+goodsid+",";	
							  bb=dad.addColl(accnum,ss, conn);
						  } 
					  } 
				  }
			  }else {
				  String ss=a.getColl_goods()+goodsid+",";	
				  bb=dad.addColl(accnum,ss, conn); 
			  }
		} catch (Exception e) {
			log.error(e);
		}finally {
			try {
				if(conn!=null&&!conn.isClosed()) {
					DbHelp.closeConnection(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
		}
	   return bb;
	}
	@Override
	public boolean deleterColl(String accnum, String goodsid) {
		 Connection conn=DbHelp.getConnection();
		 boolean bb=false;
	  try {
		 DcfAddCollDao dad=new DcfAddCollDaoImpl();
		 AccountDao ad=new AccountDaoImpl();		
//		 根据账号查询收藏商品
		Account a=ad.selectAccount(accnum, conn);
		String collgoods=a.getColl_goods();
	    String[] strs=a.getColl_goods().split(",");
	 //删除收藏商品
	    for(int i=0;i<strs.length;i++) {
	    	if(goodsid.equals(strs[i])) {
	    		collgoods=collgoods.replace(goodsid+",", "");
			}
	    }
	    bb=dad.addColl(accnum, collgoods,conn);
	  }catch (Exception e) {
		log.error(e);
	  }finally {
		  try {
			if(conn!=null&&!conn.isClosed()) {
				  DbHelp.closeConnection(conn);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
	  }  
		return bb;		
	}
}
