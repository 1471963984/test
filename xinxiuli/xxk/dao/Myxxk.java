package dao;

import java.sql.Connection;

import pojo.Account;
import pojo.Users;

public interface Myxxk {
	
	//查询有没有这个号码
    public boolean  selectaccount(String account_num,Connection con) throws Exception;
    //查询账号密码
    public boolean  selectaccountinfo(String account_num,String account_pass,Connection con) throws Exception;
    //查询并且返回Account
    public Account  selectAccountwhole(String account_num, Connection conn) throws Exception ;
    //查询用户表信息
    public Users selectUsers(String account_num, Connection conn) throws Exception;
    //跟改密码
    public boolean updateAccount(String account_num, String account_pass, Connection conn) throws Exception;
}
