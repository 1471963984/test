package serviceImpl;


import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import dao.UsersDao;
import dao.UsersZiLiaoDao;
import dao.impl.UsersDaoImpl;
import dao.impl.UsersZiLiaoDaoImpl;
import db.DbHelp;
import pojo.Users;
import service.AddAddrsService;

public class AddAddrsServiceImpl implements AddAddrsService{
	private static final Logger log = Logger.getLogger(AddAddrsServiceImpl.class);
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
			}
		    }
		} catch (Exception e) {
			log.error(e);
		}finally {
			try {
				if(conn!=null&&!conn.isClosed()) {
					DbHelp.closeConnection(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
		}
	    return flag;
	}

}
