package pojo;

import java.io.Serializable;

public class Back_order implements Serializable{
	private static final long serialVersionUID = -3085695860185312475L;
	private int oid;
	private String order_num;
	private int order_status;
	private String users_addr;
	private String users_phone;
	private String account_num;
	private String order_picture;
	private String size_name;
	private String color_name;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public String getUsers_addr() {
		return users_addr;
	}
	public void setUsers_addr(String users_addr) {
		this.users_addr = users_addr;
	}
	public String getUsers_phone() {
		return users_phone;
	}
	public void setUsers_phone(String users_phone) {
		this.users_phone = users_phone;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public String getOrder_picture() {
		return order_picture;
	}
	public void setOrder_picture(String order_picture) {
		this.order_picture = order_picture;
	}
	public String getSize_name() {
		return size_name;
	}
	public void setSize_name(String size_name) {
		this.size_name = size_name;
	}
	public String getColor_name() {
		return color_name;
	}
	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}
}
