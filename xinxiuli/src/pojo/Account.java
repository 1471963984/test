package pojo;

import java.io.Serializable;

public class Account implements Serializable{
	private static final long serialVersionUID = 873962505215991395L;
	private int account_id;
	private String account_num;
	private String account_pass;
	private String users_ip;
	private String cart_num;
	private String order_num;
	private String coll_goods;
	
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public String getAccount_pass() {
		return account_pass;
	}
	public void setAccount_pass(String account_pass) {
		this.account_pass = account_pass;
	}
	public String getUsers_ip() {
		return users_ip;
	}
	public void setUsers_ip(String users_ip) {
		this.users_ip = users_ip;
	}
	public String getCart_num() {
		return cart_num;
	}
	public void setCart_num(String cart_num) {
		this.cart_num = cart_num;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public String getColl_goods() {
		return coll_goods;
	}
	public void setColl_goods(String coll_goods) {
		this.coll_goods = coll_goods;
	}
	
}
