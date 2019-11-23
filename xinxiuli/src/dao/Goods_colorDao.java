package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Goods_color;


public interface Goods_colorDao {
	public boolean insertGoods_color(Goods_color goods_color,Connection conn);
	public boolean updateGoods_color(Goods_color goods_color,Connection conn);
	public boolean deleteGoods_color(int pid,Connection conn);
	public Goods_color selectGoods_color(int pid,Connection conn);
	public List<Goods_color> selectAllGoods_color(Connection conn);
}
