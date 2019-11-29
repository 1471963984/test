package web.xxk.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import pojo.Account;

public class SingletonSessionlistener implements HttpSessionAttributeListener{
     //Key==登录名 account_num
	 //value == 最新的session
	Map<String,HttpSession>  map =new HashMap<String,HttpSession>();
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
	 	// TODO Auto-generated method stub
	      String  name =event.getName();
	     if("account".equals(name)){
	        Account anew=(Account) event.getValue();       	  
	       if(map.get(anew.getAccount_num())!=null){
	    	   
	       HttpSession oldsession=map.get(anew.getAccount_num());
	       
	           map.remove(anew.getAccount_num());
	            
	           oldsession.removeAttribute("account");
	           
	    	   oldsession.setAttribute("accountmsg","您的帐号已经在其他机器上登录");                                      
	        }
	       map.put(anew.getAccount_num(),event.getSession());
	       System.out.println("你的账号上线"+"attributeAdd");         
	     } 
		
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		 String  name =event.getName();
		 if("account".equals(name)){
		 Account  a  =(Account)event.getValue();            	         
		     map.remove(a.getAccount_num());  
		 }
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
          String   name= event.getName();  
        // 没有注销的情况下，用另一个帐号登录
          if("account".equals(name)){
           // 移除老的         	  
            Account a=(Account)event.getValue();
            map.remove(a.getAccount_num());
            
            Account  anew=(Account)event.getSession().getAttribute("account"); 
        
            // 也要检查新登录的帐号是否在别的机器上登录过
            if(map.get(anew.getAccount_num())!=null){
              HttpSession  oldsession  =map.get(anew.getAccount_num());
              
	           oldsession.removeAttribute("account");
	           
	    	   oldsession.setAttribute("accountmsg","您的帐号已经在其他机器上登录");   
             }
              
            map.put(anew.getAccount_num(), event.getSession());
	    }
   }
}
