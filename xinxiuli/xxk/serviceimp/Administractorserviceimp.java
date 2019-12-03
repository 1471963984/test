package serviceimp;

import java.sql.Connection;
import java.sql.SQLException;

import dao.Administratordao;
import dao.imp.Administratordaoimp;
import db.DbHelp;
import service.Administractorsevice;

public class Administractorserviceimp  implements Administractorsevice{
        
	

	@Override
	public boolean admlogin(String username, String password ) {
		// TODO Auto-generated method stub
		boolean flag=false;
	    Connection conn=DbHelp.getConnection();
	    Administratordao admdao=new Administratordaoimp();
	    try {
	        conn.setAutoCommit(false); 	
		flag = admdao.selectAdministrator(username, password, conn);
		    conn.commit();
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			 try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
		       DbHelp.closeConnection(conn);	
		}
		       
		return flag;
	}
    
}
