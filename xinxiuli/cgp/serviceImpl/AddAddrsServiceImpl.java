package serviceImpl;


import java.sql.Connection;

import dao.UsersDao;
import dao.UsersZiLiaoDao;
import dao.impl.UsersDaoImpl;
import dao.impl.UsersZiLiaoDaoImpl;
import db.DbHelp;
import net.sf.json.JSONObject;
import pojo.Users;
import service.AddAddrsService;

public class AddAddrsServiceImpl implements AddAddrsService{

	@Override
	public boolean addAddrs(String account_num,Users u){
		Connection conn=DbHelp.getConnection();
		Users users = new Users();
	    UsersZiLiaoDao ud = new UsersZiLiaoDaoImpl();
	    boolean flag=false;
	   try {  
		 if(u!=null){
			Users usersinfo=ud.selectAllUsersByAccount_num(account_num, conn);
			if(usersinfo!=null) {
				//获取传过来的值,插入到数据库
				users.setUsers_id(usersinfo.getUsers_id());
		    	users.setAccount_num(account_num);
		    	users.setUsers_name(usersinfo.getUsers_name()+u.getUsers_name()+",");
		    	users.setUsers_nickname(usersinfo.getUsers_nickname()+u.getUsers_nickname()+",");
		    	users.setUsers_addr(usersinfo.getUsers_addr()+u.getUsers_addr()+",");
		    	users.setUsers_phone(usersinfo.getUsers_phone()+u.getUsers_phone()+",");
		    	users.setUsers_email(usersinfo.getUsers_email()+u.getUsers_email()+",");
				flag =ud.addAddres(users, conn);
				System.out.println(users.getAccount_num()+"添加地址成功");	
			}
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelp.closeConnection(conn);
		}
	    return flag;
	}

}
