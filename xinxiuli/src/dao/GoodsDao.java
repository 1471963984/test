package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Goods;


public interface GoodsDao {
	public boolean insertGoods(Goods goods,Connection conn);
	public boolean updateGoods(Goods goods,Connection conn);
	public boolean deleteGoods(int goods_id,Connection conn);
	public Goods selectGoods(int goods_id,Connection conn);
	public List<Goods> selectAllGoods(Connection conn);
}
