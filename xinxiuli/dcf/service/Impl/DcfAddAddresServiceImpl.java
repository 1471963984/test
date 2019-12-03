package service.Impl;

import java.sql.Connection;

import dao.UsersZiLiaoDao;
import dao.impl.UsersZiLiaoDaoImpl;
import db.DbHelp;
import pojo.Users;
import service.DcfSAddAddresService;

public class DcfAddAddresServiceImpl implements DcfSAddAddresService{

	@Override
	public boolean deleAddres(String accnum,int index) {
	   Connection conn=DbHelp.getConnection();
	   UsersZiLiaoDao uzd=new UsersZiLiaoDaoImpl();
	   boolean b=false;
	   try {
		   Users u=uzd.selectAllUsersByAccount_num(accnum, conn);
		   if(u!=null) {
	   		   Users uu=new Users();
	    		   String addr="";
	    		   String[] oldaddr=u.getUsers_addr().split(",");       		   
	    		   String pho="";
	    		   String[] oldpho=u.getUsers_phone().split(",");       		   
	        	   String unam="";
	    		   String[] oldunam=u.getUsers_name().split(",");     		   
	    		   String unick="";
	    		   String[] oldunick=u.getUsers_nickname().split(",");      		   
	    		   String uemail="";
	    		   String[] olduemail=u.getUsers_email().split(",");
	    		   for(int i=0;i<oldaddr.length;i++) {
	    			    if(i==index) {
	    			    	addr+=oldaddr[i].replace(oldaddr[i],"");
	    			    	pho+=oldpho[i].replace(oldpho[i],"");
	    			    	unam+=oldunam[i].replace(oldunam[i],"");
	    			    	unick+=oldunick[i].replace(oldunick[i],"");
	    			    	if(index<olduemail.length){
	    			    		 uemail+=olduemail[i].replace(olduemail[i],"");
	    			    	}
	    			    }else {
						   addr+=oldaddr[i]+",";
		    			   pho+=oldpho[i]+",";
		    			   unam+=oldunam[i]+",";
		    			   unick+=oldunick[i]+",";
		    			   uemail+=olduemail[i]+",";
	    			    }
	    		   }
	    		   uu.setUsers_id(u.getUsers_id());
	    		   uu.setAccount_num(u.getAccount_num());
	    		   uu.setUsers_name(unam);
	    		   uu.setUsers_nickname(unick);
	    		   uu.setUsers_addr(addr);
	    		   uu.setUsers_email(uemail);
	    		   uu.setUsers_phone(pho);
			  b=uzd.addAddres(uu, conn);	   
		   }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelp.closeConnection(conn);
		}
		return b;
	}
}
