package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Goods_size;


public interface Goods_sizeDao {
	public boolean insertGoods_size(Goods_size goods_size,Connection conn) throws Exception;
	public boolean updateGoods_size(Goods_size goods_size,Connection conn) throws Exception;
	public boolean deleteGoods_size(int sid,Connection conn) throws Exception;
	public Goods_size selectGoods_size(int sid,Connection conn) throws Exception;
//	
	public Goods_size selectGoods_sizeOne(int goodsid,int colornum,int sizenum,Connection conn) throws Exception;
	//根据一个商品编号和颜色编号，确定该颜色有几个尺寸
	public List<Goods_size> queryGoods_size(int goodsid,int colornum,Connection conn) throws Exception;
//	先拿到一个商品的所有所有尺寸
	public List<Goods_size> querysGoods_size(int goodsid,Connection conn) throws Exception;
	public List<Goods_size> selectAllGoods_size(Connection conn) throws Exception;
}
