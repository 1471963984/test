package serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;

import dao.AccountDao;
import dao.CartDao;
import dao.GoodsDao;
import dao.Goods_colorDao;
import dao.Goods_sizeDao;
import dao.MyOrderDao;
import dao.OrderDao;
import dao.UpdateKucunDao;
import dao.UsersZiLiaoDao;
import dao.impl.AccountDaoImpl;
import dao.impl.CartDaoImpl;
import dao.impl.GoodsDaoImpl;
import dao.impl.Goods_colorDaoImpl;
import dao.impl.Goods_sizeDaoImpl;
import dao.impl.MyOrderDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.UpdateKucunDaoImpl;
import dao.impl.UsersZiLiaoDaoImpl;
import db.DbHelp;
import dto.Addrs;
import dto.CartGoods;
import dto.JieSuanShow;
import dto.ShowMyCart;
import pojo.Account;
import pojo.Cart;
import pojo.Goods;
import pojo.Goods_color;
import pojo.Goods_size;
import pojo.Order;
import pojo.Users;
import service.ShowCartService;
import service.UpdataKucunService;
import service.UpdateCartGoods;
import util.Acount_status;
import web.servlet.MyOrder;

public class UpdataKucunServiceImpl implements UpdataKucunService,Acount_status{
	private static final Logger log = Logger.getLogger(UpdataKucunServiceImpl.class);
	public boolean gaiKucun(String account_num,int goods_num,String index,String judge){
		Connection conn = DbHelp.getConnection();
		boolean flag = false;
		AccountDao ad = new AccountDaoImpl();
		try {
//			conn.setAutoCommit(false);
			//通过账号找到该账号
			Account account = ad.selectAccount(account_num, conn);
			GoodsDao gd = new GoodsDaoImpl();
			//通过goods_num找到对应的商品
			Goods g = gd.selectGoods(goods_num, conn);
//			System.out.println(g.getGoods_id());
			UpdateKucunDao ukd = new UpdateKucunDaoImpl();
			//通过商品找到对应的库存
			Goods_size gs = ukd.selectGoods_sizeByAllInfo(g.getGoods_id(), g.getGoods_color_num(), g.getGoods_size_num(), conn);
			
			//地址信息
			Addrs as = getAddrs(account_num,index,conn);
			
			//商品信息
			CartGoods cg = new CartGoods();
			Goods_colorDao cds = new Goods_colorDaoImpl();
			Goods_sizeDao sd = new Goods_sizeDaoImpl();
			Goods_color color = cds.selectGoods_colorOne(g.getGoods_id(),g.getGoods_color_num(), conn);
			Goods_size size = sd.selectGoods_sizeOne(g.getGoods_id(), g.getGoods_color_num(), g.getGoods_size_num(), conn);
			
			//生成一条订单
			OrderDao od = new OrderDaoImpl();
			Order o = new Order();
			if(judge.equals("t")){
				//库存减一并更新数据库
				int xinkucun = gs.getGoods_remain()-1;
				gs.setGoods_remain(xinkucun);
				Goods_sizeDao gsd = new Goods_sizeDaoImpl();
				flag = gsd.updateGoods_size(gs, conn);
				//订单状态
				o.setOrder_status(Acount_status.DAIFAHUO);
				//更新用户购物车
				UpdateCartGoods ucg = new service.Impl.UpdateCartGoods();
				ucg.updateCartGoods(account_num, goods_num);
			}else{
				o.setOrder_status(Acount_status.DAIFUKUAN);
			}
			o.setAccount_num(account_num);
			Date s = new Date();
			String time = String.valueOf(s.getYear()+1900)+"年"+String.valueOf(s.getMonth())+"月"+String.valueOf(s.getDay())+"日"+String.valueOf(s.getHours())+"时"+String.valueOf(s.getMinutes())+"分"+String.valueOf(s.getSeconds())+"秒";
			o.setOrder_time(time);
			o.setSize_name(size.getSize_name());
			o.setColor_name(color.getColor_name());
			o.setGoods_price(String.valueOf(g.getGoods_price()));
			o.setGoods_name(g.getGoods_name());
			o.setGoods_num(goods_num);
			String tel = as.getTel();
			if(as.getTel().substring(0, 1).equals("#")){
				tel = as.getTel().substring(2);
			}
			o.setGoods_phone(tel);
			o.setShouhuoren(as.getName());
			o.setOrder_addrs(as.getDizhi());
			flag= od.insertOrder(o, conn);
//			conn.commit();
		} catch (Exception e) {
			log.error(e);
//			
		}
		finally {
			try {
				if(conn!=null&&!conn.isClosed()) {
					DbHelp.closeConnection(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
		}
		return flag;
	}
	public Addrs getAddrs(String account_num,String index,Connection conn){
		UsersZiLiaoDao uzd = new UsersZiLiaoDaoImpl();
		Addrs as = new Addrs();
		try {
			Users user = uzd.selectAllUsersByAccount_num(account_num, conn);
			int i = Integer.parseInt(index);
			String[] tel = user.getUsers_phone().split(",");
			String[] dizhi = user.getUsers_addr().split(",");
			String[] name = user.getUsers_name().split(",");
			if(tel!=null&&dizhi!=null&&name!=null){
				as.setName(name[i]);
				as.setDizhi(dizhi[i]);
				as.setTel(tel[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return as;
	}
}
