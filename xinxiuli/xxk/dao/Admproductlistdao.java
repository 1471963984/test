package dao;

import java.sql.Connection;
import java.util.List;

import dto.Admproductlist;

public interface Admproductlistdao {
   public List<Admproductlist>  selectadm(int pageNo,int pageSize ,Connection conn) throws Exception;  
   public Admproductlist  selectadmbyid(int goods_num,Connection conn) throws Exception;
   public  int   selectMaxPageNo (int pageSize,Connection conn) throws Exception;
}
