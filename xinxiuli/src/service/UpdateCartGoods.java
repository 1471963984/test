package service;

import java.util.List;

import pojo.Goods;

public interface UpdateCartGoods {
	public List<Goods> updateCartGoods(String account_num,int goods_id);
}
