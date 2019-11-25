package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Goods_size;


public interface Goods_sizeDao {
	public boolean insertGoods_size(Goods_size goods_size,Connection conn) throws Exception;
	public boolean updateGoods_size(Goods_size goods_size,Connection conn) throws Exception;
	public boolean deleteGoods_size(int sid,Connection conn) throws Exception;
	public Goods_size selectGoods_size(int sid,Connection conn) throws Exception;
	public List<Goods_size> selectAllGoods_size(Connection conn) throws Exception;
}
