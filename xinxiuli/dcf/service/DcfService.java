package service;

import java.sql.Connection;

import dto.ShowOneGoods;

public interface DcfService {

    public ShowOneGoods show(int goodnum,String accnum);
    public int selectNumber(int gid,int cid,int sid,String account_num);
    public boolean addColl(String accnum,String gooid);
    public boolean deleterColl(String accnum,String gooid);
 
}
