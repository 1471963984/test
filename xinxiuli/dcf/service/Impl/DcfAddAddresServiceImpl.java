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
    		   String addr=u.getUsers_addr();
    		   String[] newaddr=addr.split(",");
    		   String pho=u.getUsers_phone();
    		   String[] newpho=pho.split(",");
    		   String unam=u.getUsers_name();
    		   String[] newunam=unam.split(",");
    		   String unick=u.getUsers_nickname();
    		   String[] newunick=unick.split(",");
    		   String uemail=u.getUsers_email();
    		   String[] newuemail=uemail.split(",");
    		   for(int i=0;i<newaddr.length;i++) {
    			    if(i==index) {
    			    	addr=addr.replace(newaddr[i]+",","");
    			    	pho=pho.replace(newpho[i]+",","");
    			    	unam=unam.replace(newunam[i]+",","");
    			    	unick=unick.replace(newunick[i]+",","");
    			    	if(index<newuemail.length){
    			    		uemail=uemail.replace(newuemail[i]+",","");
    			    	}
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
