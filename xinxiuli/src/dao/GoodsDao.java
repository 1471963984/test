package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Goods;


public interface GoodsDao {
	public boolean insertGoods(Goods goods,Connection conn) throws Exception;
	public boolean updateGoods(Goods goods,Connection conn) throws Exception;
	public boolean deleteGoods(int goods_num,Connection conn) throws Exception;
	public Goods selectGoods(int goods_num,Connection conn) throws Exception;
	public List<Goods> selectAllGoods(int goods_id,Connection conn) throws Exception;
}
