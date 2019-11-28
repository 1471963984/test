package dao;

import java.sql.Connection;

public interface DcfGoodsDao extends GoodsDao{
     public int selectNumber(int gid,int cid,int sid,Connection conn) throws Exception;
}
