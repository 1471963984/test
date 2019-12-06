package serviceimp;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import dao.Administratordao;
import dao.imp.Administratordaoimp;
import db.DbHelp;
import service.Administractorsevice;
import service.Impl.FindDiviedGoods;

public class Administractorserviceimp  implements Administractorsevice{
        
	
	private static final Logger log = Logger.getLogger(Administractorserviceimp.class);
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
				log.error(e);
			}
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
		       
		return flag;
	}
    
}
