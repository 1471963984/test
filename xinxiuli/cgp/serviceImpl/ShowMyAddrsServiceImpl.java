package serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.UsersZiLiaoDao;
import dao.impl.UsersZiLiaoDaoImpl;
import db.DbHelp;
import pojo.Users;
import service.ShowMyAddrsService;
import service.Impl.FindDiviedGoods;

public class ShowMyAddrsServiceImpl implements ShowMyAddrsService{
	private static final Logger log = Logger.getLogger(ShowMyAddrsServiceImpl.class);
	@Override
	public List<String[]> showAddres(String accnum) {
		Connection conn = DbHelp.getConnection();
		List<String[]> l=new ArrayList<String[]>();
		Users u=new Users();
		UsersZiLiaoDao uzd=new UsersZiLiaoDaoImpl();
		try {
		  u=uzd.selectAllUsersByAccount_num(accnum, conn);
		  if(u!=null) {
			  String str=u.getUsers_phone();
			  String[] strs=u.getUsers_phone().split(",");
			  String[] newstrs=new String[strs.length];
			  String[] index=new String[1];
			  for(int i=0;i<strs.length;i++) {
				  newstrs[i]=strs[i]; 
				  if("##".equals(strs[i].substring(0,2))) {
					  newstrs[i]=strs[i].substring(2);
					  index[0]=String.valueOf(i);
				  }
			  }
			  l.add(newstrs);
			  l.add(u.getUsers_name().split(","));
			  l.add(u.getUsers_nickname().split(","));
			  l.add(u.getUsers_addr().split(","));
			  l.add(u.getUsers_email().split(","));
			  l.add(index);
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
		return l;
	}

	@Override
	public boolean UpdateDefulAddres(String accnum,int index) {
		Connection conn = DbHelp.getConnection();
		Users u=new Users();
		UsersZiLiaoDao uzd=new UsersZiLiaoDaoImpl();
		 boolean flag=false;
		try {
		  u=uzd.selectAllUsersByAccount_num(accnum, conn);
		  String str=u.getUsers_phone();
		  if(u!=null) {
			  String[] upho=u.getUsers_phone().split(",");
			  StringBuffer sb=new StringBuffer();
			  for(int i=0;i<upho.length;i++) {
				  if("##".equals(upho[i].substring(0,2))) {
					  sb.append(upho[i].substring(2)+",");
					 continue;
				  }			
				  if(i==index) {
					  sb.append("##"+upho[i]+",");
					  continue;
				  }
				  sb.append(upho[i]+","); 
			  }
			  u.setUsers_phone(sb.toString());
			  flag=uzd.addAddres(u, conn);
		  }	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelp.closeConnection(conn);
		}
		return flag;
	}
	
}
