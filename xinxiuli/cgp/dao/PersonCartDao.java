package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Goods;

public interface PersonCartDao extends AccountDao{
	public String selectAllMyGoods(String account_num,Connection conn) throws Exception;
}
