package dao;

import java.sql.Connection;

import pojo.Administrator;

public interface Administratordao {
	//账号检查
    public  boolean  selectusername(String username, Connection conn) throws Exception;
    //账号密码
    public  boolean  selectAdministrator(String username,String password,Connection  conn ) throws Exception; 
}
