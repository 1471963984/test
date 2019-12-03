package dao;

import java.sql.Connection;

import pojo.Goods_size;

public interface UpdateKucunDao extends Goods_sizeDao{
	public Goods_size selectGoods_sizeByAllInfo(int goods_id,int color_num,int size_num,Connection conn) throws Exception;
	
}
