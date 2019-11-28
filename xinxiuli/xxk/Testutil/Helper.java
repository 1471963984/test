package Testutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Helper {
	
   static {
	   try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	      
   }
   
  public static Connection getcon() {
	 Connection con=null;
	 
	     try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/xinxiuli?characterEncoding=utf8&userUnicode=true ", "root", "123456");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studying?characterEncoding=utf8&userUnicode=true ", "root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	  return con;
   }

     public static void ConnecctionClose( Connection con ) {
	  try {
		if(con!=null&&con.isClosed() ) {
			con.close();  	  
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }  
//  public static void main(String[] args) {
//	System.out.println(Helper.getcon());
// }
}
