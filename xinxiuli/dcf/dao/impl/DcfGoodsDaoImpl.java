package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dao.DcfGoodsDao;
import pojo.Goods;

public class DcfGoodsDaoImpl implements DcfGoodsDao{

	@Override
	public boolean insertGoods(Goods goods, Connection conn) throws Exception {
		return false;
	}

	@Override
	public boolean updateGoods(Goods goods, Connection conn) throws Exception {
		return false;
	}

	@Override
	public boolean deleteGoods(int goods_num, Connection conn) throws Exception {
		return false;
	}

	@Override
	public Goods selectGoods(int goods_num, Connection conn) throws Exception {
		return null;
	}

	@Override
	public List<Goods> selectAllGoods(int goods_id, Connection conn) throws Exception {
	
		return null;
	}

	@Override
	public int selectNumber(int gid,int cid,int sid,Connection conn) throws Exception {
		String sql = "select goods_num from goods where goods_id=? and goods_color_num=? and goods_size_num=?";
		int mgoodsid=0;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, gid);
		ps.setInt(2, cid);
		ps.setInt(3, sid);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			mgoodsid=rs.getInt("goods_num");
		}
		return mgoodsid;
	}

	@Override
	public Goods selectGoodsById(int goods_id, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
