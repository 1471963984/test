package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Testutil.Helper;
import dao.Admproductlistdao;
import dto.Admproductlist;

public class Admproductlistimp implements Admproductlistdao {

	@Override
	public List<Admproductlist> selectadm(int pageNo, int pageSize, Connection conn) throws Exception {
		ArrayList<Admproductlist> list = new ArrayList<Admproductlist>();
		ResultSet rs = null;
		Admproductlist admlist = null;

		String sql = "SELECT c.goods_num ,c.goods_id,c.goods_price,c.goods_name,gcl.color_name,c.size_name,c.goods_remain,c.goods_picture " + 
				"FROM (SELECT gs.goods_picture,gs.goods_num,gs.goods_id,gs.goods_price,gs.goods_name,gz.goods_remain,gz.color_num,gz.size_num,gz.size_name " + 
				"from goods AS gs JOIN goods_size AS gz on gs.goods_id = gz.goods_id AND gs.goods_color_num =gz.color_num " + 
				"and  gs.goods_size_num =gz.size_num ) AS c JOIN goods_color  AS  gcl " + 
				"ON c.goods_id=gcl.goods_id AND c.color_num=gcl.color_num " + 
				"order by c.goods_num  ASC " + 
				"limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pageNo - 1) * pageSize);
		ps.setInt(2, pageSize);
		rs = ps.executeQuery();
		while (rs.next()) {
			admlist = new Admproductlist();
			admlist.setGoods_num(rs.getInt("goods_num"));
			admlist.setGoods_id(rs.getInt("goods_id"));
			admlist.setGoods_price(rs.getDouble("goods_price"));
			admlist.setGoods_name(rs.getString("goods_name"));
			admlist.setColor_name(rs.getString("color_name"));
			admlist.setSize_name(rs.getString("size_name"));
			admlist.setGoods_picture(rs.getString("goods_picture"));
			admlist.setGoods_remain(rs.getInt("goods_remain"));
			list.add(admlist);
		}
		return list;
	}

	@Override
	public Admproductlist selectadmbyid(int goods_num, Connection conn) throws Exception {
		Admproductlist admlist=null;
		ResultSet rs =null;
		String sql="SELECT c.goods_num ,c.goods_id,c.goods_price,c.goods_name,gcl.color_name,c.size_name,c.goods_remain,c.goods_picture" + 
				" FROM (SELECT gs.goods_picture,gs.goods_num,gs.goods_id,gs.goods_price,gs.goods_name,gz.goods_remain,gz.color_num,gz.size_num,gz.size_name " + 
				" from goods AS gs JOIN goods_size AS gz on gs.goods_id = gz.goods_id AND gs.goods_color_num =gz.color_num" + 
				" and  gs.goods_size_num =gz.size_num ) AS c JOIN goods_color  AS  gcl" + 
				" ON c.goods_id=gcl.goods_id AND c.color_num=gcl.color_num" + 
				" WHERE goods_num=?";
		 PreparedStatement ps=conn.prepareStatement(sql);
		 ps.setInt(1, goods_num);
		 rs=ps.executeQuery();
		 if(rs.next()){
			 admlist = new Admproductlist();
			 admlist.setGoods_num(rs.getInt("goods_num"));
			 admlist.setGoods_id(rs.getInt("goods_id"));
			 admlist.setGoods_price(rs.getDouble("goods_price"));
			 admlist.setGoods_name(rs.getString("goods_name"));
			 admlist.setColor_name(rs.getString("color_name"));
			 admlist.setSize_name(rs.getString("size_name"));
			 admlist.setGoods_picture(rs.getString("goods_picture"));
			 admlist.setGoods_remain(rs.getInt("goods_remain"));	 
		 }
		return admlist;
	}

	@Override
	public int selectMaxPageNo(int pageSize,Connection conn) throws Exception {
		int count=0;
		 
		String sql="SELECT COUNT(*) FROM (SELECT gs.goods_picture,gs.goods_num,gs.goods_id,gs.goods_price,gs.goods_name,gz.goods_remain,gz.color_num,gz.size_num,gz.size_name "+ 
				" from goods AS gs JOIN goods_size AS gz on gs.goods_id = gz.goods_id AND gs.goods_color_num =gz.color_num "+ 
				" and  gs.goods_size_num =gz.size_num ) AS c JOIN goods_color  AS  gcl "+ 
				" ON c.goods_id=gcl.goods_id AND c.color_num=gcl.color_num";
       PreparedStatement ps = conn.prepareStatement(sql);
       ResultSet rs=ps.executeQuery();
       if(rs.next()) {
        count=rs.getInt(1);   
       }
	return count%pageSize==0 ? count/pageSize : count/pageSize+1;
	}	
	

}
