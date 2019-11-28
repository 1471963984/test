package dao;

import java.sql.Connection;

public interface DcfAddCard extends CartDao{
      public boolean addGoodsMyCard(String cartnum,String goodsid,Connection conn)throws Exception;
}
