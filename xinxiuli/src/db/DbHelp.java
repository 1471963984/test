package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbHelp {
	private static Context context=null;
	private static DataSource ds=null;
    static {
        try {
        	context=new InitialContext();
        	getDataSource();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
		try {
			ds = (DataSource)context.lookup("java:comp/env/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
    }
    public static Connection getConnection(){
        Connection conn=null;
        try {
            if(ds!=null) {
            	conn=ds.getConnection();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn){
        try {
            if (conn!=null&&!conn.isClosed()){
                conn.close();       
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
