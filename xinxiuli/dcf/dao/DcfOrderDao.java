package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Order;

public interface DcfOrderDao extends OrderDao{
     public List<Order> selectAllUserOrders(String accountnum,int status,Connection conn) throws Exception;
     public List<Order> queryAdminUnshippedOrders(int status,Connection conn) throws Exception;
    // public List<Order> AdminQueryOneUser(String accnum,Connection conn) throws Exception; 
}
