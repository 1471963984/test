package serviceImpl;


import java.sql.Connection;

import dao.UsersDao;
import dao.UsersZiLiaoDao;
import dao.impl.UsersDaoImpl;
import dao.impl.UsersZiLiaoDaoImpl;
import net.sf.json.JSONObject;
import pojo.Users;
import service.AddAddrsService;

public class AddAddrsServiceImpl implements AddAddrsService{

	@Override
	public Users addAddrs(String account_num,Users u, Connection conn) throws Exception {
		Users users = new Users();
	    UsersZiLiaoDao ud = new UsersZiLiaoDaoImpl();
	    UsersDao udd = new UsersDaoImpl();
		//获取传过来的值,插入到数据库
	    if(u!=null){
//	    	JSONObject jo = JSONObject.fromObject(user);
//	    	Users u = (Users) JSONObject.toBean(jo, Users.class);
	    	users.setAccount_num(account_num);
	    	users.setUsers_name(u.getUsers_name());
	    	users.setUsers_nickname(u.getUsers_nickname());
	    	users.setUsers_addr(u.getUsers_addr());
	    	users.setUsers_phone(u.getUsers_phone());
	    	users.setUsers_email(u.getUsers_email());
	    	try {
				boolean flag = udd.insertUsers(users, conn);
				System.out.println(users.getAccount_num()+"添加地址成功");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    return users;
	}

}
