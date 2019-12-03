package dao.imp;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Testutil.Helper;
import dao.Administratordao;
import pojo.Administrator;

public class Administratordaoimp implements Administratordao{

	@Override
	public boolean selectusername(String username, Connection conn) throws Exception {
		boolean  flag= false;
		ResultSet rs=null;
		String sql="select * from administractor where username=?";
	    PreparedStatement  ps =conn.prepareStatement(sql);
	    ps.setString(1,username);
	    rs = ps.executeQuery();
	    if(rs.next()){
	        flag=true; 	
	    }
		return flag;
	}

	@Override
	public boolean selectAdministrator(String username,String password,Connection conn) throws Exception {

		boolean  flag= false;
		ResultSet rs=null;
		String sql="select * from administractor where username=? and password=?";
	    PreparedStatement  ps =conn.prepareStatement(sql);
	    ps.setString(1,username);
	    ps.setString(2,password);
	    rs = ps.executeQuery();
	    if(rs.next()){
	        flag=true; 	
	    }
		return flag;
		
	}
	
	
//   public static void main(String[] args) {
//      Connection conn=Helper.getcon();
//      Administratordaoimp dao = new Administratordaoimp();
//            Administrator adm=new Administrator();
//            	adm.setUsername("123xxk");
//                adm.setPassword("1234xxk");
//    
//         try {
//        	System.out.println(dao.selectAdministrator(adm, conn)); ;
//			//System.out.println(dao.selectusername("13xxk", conn));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//     }
   
   
}
