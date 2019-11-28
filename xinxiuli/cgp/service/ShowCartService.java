package service;

import java.sql.Connection;
import java.util.List;

import pojo.Cart;
import pojo.Goods;

public interface ShowCartService {
	public List<Goods> selectAllMygoods(String account_num) throws Exception;

}
