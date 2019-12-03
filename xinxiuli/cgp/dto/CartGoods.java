package dto;

public class CartGoods {
	private String goods_img;
	private String goods_desc;
	private String goods_name;
	private String goods_color;
	private String goods_size;
	private double goods_price;
	private String list_size;
	private int goods_num;
	
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}
	public String getList_size() {
		return list_size;
	}
	public void setList_size(String list_size) {
		this.list_size = list_size;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}
	public String getGoods_desc() {
		return goods_desc;
	}
	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_color() {
		return goods_color;
	}
	public void setGoods_color(String goods_color) {
		this.goods_color = goods_color;
	}
	public String getGoods_size() {
		return goods_size;
	}
	public void setGoods_size(String goods_size) {
		this.goods_size = goods_size;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	@Override
	public String toString() {
		return "CartGoods [goods_img=" + goods_img + ", goods_desc=" + goods_desc + ", goods_name=" + goods_name
				+ ", goods_color=" + goods_color + ", goods_size=" + goods_size + ", goods_price=" + goods_price
				+ ", list_size=" + list_size + ", goods_num=" + goods_num + ", getGoods_num()=" + getGoods_num()
				+ ", getList_size()=" + getList_size() + ", getGoods_img()=" + getGoods_img() + ", getGoods_desc()="
				+ getGoods_desc() + ", getGoods_name()=" + getGoods_name() + ", getGoods_color()=" + getGoods_color()
				+ ", getGoods_size()=" + getGoods_size() + ", getGoods_price()=" + getGoods_price() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
