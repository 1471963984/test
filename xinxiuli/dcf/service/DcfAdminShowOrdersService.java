package service;

import java.util.List;

import pojo.Order;

public interface DcfAdminShowOrdersService {
     public List<Order> showOrders();
     public List<Order> AdminQueryUnshipped(int statas);
     public List<Order> AdminQueryOneUser(String accnum);
}
