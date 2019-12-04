package service;

import java.sql.Connection;

import dto.Addrs;
import dto.JieSuanShow;
import dto.ShowMyCart;
import pojo.MyOrders;
import pojo.Users;

public interface UpdataKucunService {
	public boolean gaiKucun(String account_num,int goods_num,String index,String judge);
	public Addrs getAddrs(String account,String index,Connection conn);
}
