package service;

import java.sql.Connection;
import java.util.List;

import dto.ShowMyCart;
import pojo.Cart;

public interface ShowCartService {
	public List<ShowMyCart> selectAllMygoods(String account_num) throws Exception;

}
