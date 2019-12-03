package dto;

import java.util.List;

public class JieSuanShow {
	
	private List<Addrs> addrs;
	private List<CartGoods> goods;
	
	public List<Addrs> getAddrs() {
		return addrs;
	}
	public void setAddrs(List<Addrs> addrs) {
		this.addrs = addrs;
	}
	public List<CartGoods> getGoods() {
		return goods;
	}
	public void setGoods(List<CartGoods> goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "JieSuanShow [addrs=" + addrs + ", goods=" + goods + "]";
	}
}
