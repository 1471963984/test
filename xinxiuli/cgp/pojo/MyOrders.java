package pojo;

import java.io.Serializable;

public class MyOrders extends Order implements Serializable {
	private static final long serialVersionUID = -2135250234852410886L;
	private int order_num;
	private int goods_id;
	private int order_status;
	private String account_num;
	private String order_time;
	private int color_num;
	private int size_num;
	private String order_addrs;
	
	public String getOrder_addrs() {
		return order_addrs;
	}
	public void setOrder_addrs(String order_addrs) {
		this.order_addrs = order_addrs;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public int getColor_num() {
		return color_num;
	}
	public void setColor_num(int color_num) {
		this.color_num = color_num;
	}
	public int getSize_num() {
		return size_num;
	}
	public void setSize_num(int size_num) {
		this.size_num = size_num;
	}
	
	
	
}
