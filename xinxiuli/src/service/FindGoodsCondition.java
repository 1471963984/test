package service;

import java.util.List;
import java.util.Map;

import pojo.Goods;

public interface FindGoodsCondition {
	public List<Goods> findGoodsCondition(Map<String, String> map);
}
