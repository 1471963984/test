package pojo;

import java.io.Serializable;

public class Order implements Serializable {
	private static final long serialVersionUID = -2135250234852410886L;
	private String order_num;
	private int goods_id;
	private int order_status;
	private String account_num;
	private int users_id;
	private String oder_time;
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
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
	public int getUsers_id() {
		return users_id;
	}
	public void setUser_id(int users_id) {
		this.users_id = users_id;
	}
	public String getOder_time() {
		return oder_time;
	}
	public void setOder_time(String oder_time) {
		this.oder_time = oder_time;
	}

}
