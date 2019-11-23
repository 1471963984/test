package dao;

import java.sql.Connection;
import java.util.List;
import pojo.Goods_detail;


public interface Goods_detailDao {
	public boolean insertGoods_detail(Goods_detail goods_detail,Connection conn);
	public boolean updateGoods_detail(Goods_detail goods_detail,Connection conn);
	public boolean deleteGoods_detail(int detail_id,Connection conn);
	public Goods_detail selectGoods_color(int detail_id,Connection conn);
	public List<Goods_detail> selectAllGoods_detail(Connection conn);
}
