package service;

import java.sql.Connection;
import java.util.List;

import dto.Addrs;
import dto.CartGoods;
import dto.JieSuanShow;
import pojo.Users;

public interface JieSuanService {
	public List<Addrs> getMyAddrs(String account_num,Connection conn);
	public CartGoods getMyGoods(String account_num,int goods_num,Connection conn) throws Exception;
}
