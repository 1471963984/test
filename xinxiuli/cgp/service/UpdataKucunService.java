package service;

import java.sql.Connection;

import pojo.MyOrders;

public interface UpdataKucunService {
	public boolean gaiKucun(String account_num,int goods_num);
	public boolean updateMyCart();
	public boolean updateAccountOrder(MyOrders o, String account_num,Connection conn);
}
