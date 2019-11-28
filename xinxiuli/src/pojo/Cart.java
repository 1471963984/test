package pojo;

import java.io.Serializable;

public class Cart implements Serializable {
	private static final long serialVersionUID = 3754268379094494283L;
	private String cart_num;
	private int divied_num;
	private String goods_id;
	private int goods_count;
	public String getCart_num() {
		return cart_num;
	}
	public void setCart_num(String cart_num) {
		this.cart_num = cart_num;
	}
	public int getDivied_num() {
		return divied_num;
	}
	public void setDivied_num(int divied_num) {
		this.divied_num = divied_num;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public int getGoods_count() {
		return goods_count;
	}
	public void setGoods_count(int goods_count) {
		this.goods_count = goods_count;
	}
	
	
	
}
