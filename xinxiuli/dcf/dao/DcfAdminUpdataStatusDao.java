package dao;

import java.sql.Connection;

public interface DcfAdminUpdataStatusDao extends OrderDao{
     public boolean updataStatus(String accnum,int status,Connection conn) throws Exception;
}
