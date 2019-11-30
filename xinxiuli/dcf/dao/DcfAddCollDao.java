package dao;

import java.sql.Connection;

public interface DcfAddCollDao extends AccountDao{
     public boolean addColl(String accnum,String goodsid, Connection conn) throws Exception;
}
