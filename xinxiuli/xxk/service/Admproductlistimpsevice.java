package service;

import java.sql.Connection;
import java.util.List;

import dto.Admproductlist;

public interface Admproductlistimpsevice {
	public List<Admproductlist> selectadmlist(int pageNo, int pageSize );       
	public Admproductlist  selectadmbyid(int goods_num) ;
	public  int   selectMaxPageNo (int pageSize);


}
