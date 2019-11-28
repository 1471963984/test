package service;

import java.util.List;
import pojo.Order;

public interface DcfOrdersService{
	public List<Order> selectAllUserOrders(String accountnum,int status);
}
