package Testutil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Myutil {
	     
	 public  static  String getRemoteHost(javax.servlet.http.HttpServletRequest request){
         String ip = request.getHeader("x-forwarded-for");
         if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
                 ip = request.getHeader("Proxy-Client-IP");
         }
         if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
                 ip = request.getHeader("WL-Proxy-Client-IP");
         }
         if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
                 ip = request.getRemoteAddr();
         }
         return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
    }
  
	//MD5加密 
	   public static String Encryptin( String s) {
		   
		   MessageDigest md =null;
		   StringBuffer sb =null;
		try {
			 md = MessageDigest.getInstance("MD5");
			 md.update(s.getBytes());
			 byte[] result=md.digest();
			    sb= new StringBuffer();
			  
			    for (byte b : result) {
			   sb.append(Integer.toHexString(b));	
				}	
			 
		     } catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    } 
		   return sb.toString();	
	}  
	 
}
