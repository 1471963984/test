package service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.UsersDao;
import dao.impl.UsersDaoImpl;
import db.DbHelp;
import dto.AdminAllUserInfo;
import pojo.Users;
import service.DcfAdminShowUsersService;

public class DcfAdminShowUsersServiceImpl implements DcfAdminShowUsersService{
	private static final Logger log = Logger.getLogger(DcfAdminShowUsersServiceImpl.class);
	@Override
	public List<AdminAllUserInfo> showUsers() {
		Connection conn=DbHelp.getConnection();
		List<Users> l=new ArrayList<Users>();
		List<AdminAllUserInfo> list=new ArrayList<>();
		UsersDao ud=new UsersDaoImpl();
		try {
			l=ud.selectAllUsers(conn);
			for (Users users : l) {		
				if(users.getUsers_name()!=null&&users.getUsers_addr()!=null) {
					AdminAllUserInfo aai=new AdminAllUserInfo();
					aai.setUsersid(users.getUsers_id());
					aai.setAccountnum(users.getAccount_num());
					aai.setUsername(users.getUsers_name().split(","));
					aai.setUsernick(users.getUsers_nickname().split(","));
					aai.setUseremail(users.getUsers_email().split(","));
					aai.setUseraddr(users.getUsers_addr().split(","));
					String[] strs=users.getUsers_phone().split(",");
					String[] newstrs=new String[strs.length];
					int index=0;
					for(int i=0;i<strs.length;i++) {
					       newstrs[i]=strs[i];
						if("##".equals(strs[i].substring(0,2))) {
							newstrs[i]=strs[i].substring(2);
							index=i;
						}
					}
					aai.setUserphone(newstrs);
					aai.setIndex(index);
					list.add(aai);			
				}else {
					AdminAllUserInfo aai=new AdminAllUserInfo();
					aai.setUsersid(users.getUsers_id());
					aai.setAccountnum(users.getAccount_num());
					
					list.add(aai);	
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
		return list;
	}

}
