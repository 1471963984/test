package serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

import dao.AccountDao;
import dao.CartDao;
import dao.GoodsDao;
import dao.Goods_sizeDao;
import dao.MyOrderDao;
import dao.OrderDao;
import dao.UpdateKucunDao;
import dao.impl.AccountDaoImpl;
import dao.impl.CartDaoImpl;
import dao.impl.GoodsDaoImpl;
import dao.impl.Goods_sizeDaoImpl;
import dao.impl.MyOrderDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.UpdateKucunDaoImpl;
import db.DbHelp;
import pojo.Account;
import pojo.Cart;
import pojo.Goods;
import pojo.Goods_size;
import pojo.MyOrders;
import pojo.Order;
import service.UpdataKucunService;
import util.Acount_status;
import web.servlet.MyOrder;

public class UpdataKucunServiceImpl implements UpdataKucunService,Acount_status{
	public boolean gaiKucun(String account_num,int goods_num){
		boolean flag = false;
		
		Connection conn = DbHelp.getConnection();
		try {
//			conn.setAutoCommit(false);
			//通过账号找到该账号
			GoodsDao gd = new GoodsDaoImpl();
			//通过goods_num找到对应的商品
			Goods g = gd.selectGoods(goods_num, conn);
//			System.out.println(g.getGoods_id());
			UpdateKucunDao ukd = new UpdateKucunDaoImpl();
			//通过商品找到对应的库存
			Goods_size gs = ukd.selectGoods_sizeByAllInfo(g.getGoods_id(), g.getGoods_color_num(), g.getGoods_size_num(), conn);
			
			//库存减一并更新数据库
			int xinkucun = gs.getGoods_remain()-1;
//			System.out.println(xinkucun);
			gs.setGoods_remain(xinkucun);
			Goods_sizeDao gsd = new Goods_sizeDaoImpl();
			flag = gsd.updateGoods_size(gs, conn);
			
//			System.out.println(g.getGoods_num()+"的库存已减一");
			//生成一条订单
			MyOrderDao mod = new MyOrderDaoImpl();
			MyOrders o = new MyOrders();
			Date s = new Date();
//			String str = String.valueOf(s.getYear()+1900)+String.valueOf(s.getMonth())+String.valueOf(s.getDate())+String.valueOf(s.getHours())+String.valueOf(s.getMinutes())+String.valueOf(s.getSeconds());
//			System.out.println(str);
//			o.setOrder_num(str);
			o.setGoods_id(g.getGoods_id());
			o.setOrder_status(Acount_status.DAIFAHUO);
			o.setAccount_num(account_num);
			String time = String.valueOf(s.getYear()+1900)+"年"+String.valueOf(s.getMonth())+"月"+String.valueOf(s.getDay())+"日"+String.valueOf(s.getHours())+"时"+String.valueOf(s.getMinutes())+"分"+String.valueOf(s.getSeconds())+"秒";
			o.setOrder_time(time);
			o.setColor_num(g.getGoods_color_num());
			o.setSize_num(g.getGoods_size_num());
			
			flag= mod.insertOrder(o, conn);
			//把订单编号插入账号表
//			if(flag){
//				updateAccountOrder(o,account_num,conn);
//			}
			
			//更新用户购物车
//			CartDao cd = new CartDaoImpl();
////			System.out.println("购物车"+account);//成功
//			Cart ct = cd.selectCart(account.getCart_num(), conn);
//			//通过购物车获取goods_num
//			String goods_nums = ct.getGoods_id();
//			String[] str = goods_nums.split(",");
			
//			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
		}
		return flag;
	}
	
	public boolean updateAccountOrder(MyOrders o, String account_num,Connection conn){
		boolean flag = false;
		AccountDao ad = new AccountDaoImpl();
		MyOrderDao mod = new MyOrderDaoImpl();
		Account account;
		try {
			account = ad.selectAccount(account_num, conn);
			if(account.getOrder_num()==null&&account.getOrder_num()==""){
				System.out.println("为空时"+o.getOrder_num());
				flag = mod.updateAccountOrder(account_num, String.valueOf(o.getOrder_num())+",", conn);
			}else{
				System.out.println("不为空时"+o.getOrder_num());
				flag = mod.updateAccountOrder(account_num, account.getOrder_num()+String.valueOf(o.getOrder_num())+",", conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		Thread.sleep(500);
		return false;
		
	}
	
	public boolean updateMyCart(){
		Connection conn=DbHelp.getConnection();
		//通过账号获得cart-num
		AccountDao ad = new AccountDaoImpl();
//		Account account = ad.selectAccount(account_num, conn);
		
		
		
		return false;
		
	}
	
}
