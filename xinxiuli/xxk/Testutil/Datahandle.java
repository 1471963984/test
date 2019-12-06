package Testutil;

import java.util.ArrayList;

import java.util.List;

import pojo.Users;
import serviceImpl.ShowMyAddrsServiceImpl;

public class Datahandle {
   public  static Users dataloander(String account){
	 Users  user=null;
	 List<String[]> list=null;
   ShowMyAddrsServiceImpl showdao =new  ShowMyAddrsServiceImpl();
      list=showdao.showAddres(account);
     if(list!=null&&list.size()!=0) {
       user=new Users();    
	  String[] usersphone = list.get(0);
	  String[] usersname = list.get(1);
	  String[] usersnickname = list.get(2);
	  String[] usersaddr = list.get(3);
	  String[] usersemail = list.get(4);
	  user.setAccount_num(account);
	  user.setUsers_phone(usersphone[0]);
	  if(!"".equals(usersname[0])) {
		  user.setUsers_name(usersname[0]);
	  }
	  if(!"".equals(usersnickname[0])) {
		  user.setUsers_nickname(usersnickname[0]);
	  }
	  if(!"".equals(usersaddr[0])) {
		  user.setUsers_addr(usersaddr[0]);
	  }
	  if(!"".equals(usersemail[0])) {
		  user.setUsers_email(usersemail[0]);
	  }
     }
	  return user;  
   }  

}
