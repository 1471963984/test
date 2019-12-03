package pojo;

import java.io.Serializable;

public class Order implements Serializable {
	private static final long serialVersionUID = -2135250234852410886L;
	private int order_num;
	private int goods_num;
	private int order_status;
	private String account_num;
	private String goods_phone;
	private String color_name;
	private String size_name;
	private String order_addrs;
	private String goods_name;
	private String shouhuoren;
	private String goods_price;
	private String order_time;
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
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
	public String getGoods_phone() {
		return goods_phone;
	}
	public void setGoods_phone(String goods_phone) {
		this.goods_phone = goods_phone;
	}
	public String getColor_name() {
		return color_name;
	}
	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}
	public String getSize_name() {
		return size_name;
	}
	public void setSize_name(String size_name) {
		this.size_name = size_name;
	}
	public String getOrder_addrs() {
		return order_addrs;
	}
	public void setOrder_addrs(String order_addrs) {
		this.order_addrs = order_addrs;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getShouhuoren() {
		return shouhuoren;
	}
	public void setShouhuoren(String shouhuoren) {
		this.shouhuoren = shouhuoren;
	}
	public String getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(String goods_price) {
		this.goods_price = goods_price;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	
}
