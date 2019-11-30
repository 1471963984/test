package dao;

import java.sql.Connection;

public interface DcfAddCardDao extends CartDao{
      public boolean addGoodsMyCard(String cartnum,String goodsid,Connection conn)throws Exception;
}
