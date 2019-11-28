package dao;

import java.sql.Connection;

import pojo.Goods_detail;

public interface DcfGoods_detailDao extends Goods_detailDao {
     public Goods_detail queryPhoto(int goodsid,Connection conn) throws Exception;
}
