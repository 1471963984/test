package service;

import java.sql.Connection;

import dto.ShowOneGoods;

public interface DcfService {
    public ShowOneGoods show(int goodnum);
    public int selectNumber(int gid,int cid,int sid);
}
