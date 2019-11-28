package service;

import java.util.List;

import pojo.Goods;

public interface FindCollGoods {
	public List<Goods> findCollGoods(String account_num);
}
