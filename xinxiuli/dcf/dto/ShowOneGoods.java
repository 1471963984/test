package dto;

import java.io.Serializable;

public class ShowOneGoods implements Serializable {
	private static final long serialVersionUID = 8925084883877392572L;
	//商品详情
	private int goods_id;
	private int divied_num;
	private String goods_desc;
	private double goods_price;
	private String goods_name;
	private int goods_star;
	private int goods_color_num;
	private int goods_size_num;
	private String goods_picture;
	//商品颜色
	private String color_name;
	private String goods_delpicture;
	//商品尺寸和库存
	 private String size_name;
    private String size_picture;
    private int goods_remain;
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getDivied_num() {
		return divied_num;
	}
	public void setDivied_num(int divied_num) {
		this.divied_num = divied_num;
	}
	public String getGoods_desc() {
		return goods_desc;
	}
	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getGoods_star() {
		return goods_star;
	}
	public void setGoods_star(int goods_star) {
		this.goods_star = goods_star;
	}
	public int getGoods_color_num() {
		return goods_color_num;
	}
	public void setGoods_color_num(int goods_color_num) {
		this.goods_color_num = goods_color_num;
	}
	public int getGoods_size_num() {
		return goods_size_num;
	}
	public void setGoods_size_num(int goods_size_num) {
		this.goods_size_num = goods_size_num;
	}
	public String getGoods_picture() {
		return goods_picture;
	}
	public void setGoods_picture(String goods_picture) {
		this.goods_picture = goods_picture;
	}
	public String getColor_name() {
		return color_name;
	}
	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}
	public String getGoods_delpicture() {
		return goods_delpicture;
	}
	public void setGoods_delpicture(String goods_delpicture) {
		this.goods_delpicture = goods_delpicture;
	}
	public String getSize_name() {
		return size_name;
	}
	public void setSize_name(String size_name) {
		this.size_name = size_name;
	}
	public String getSize_picture() {
		return size_picture;
	}
	public void setSize_picture(String size_picture) {
		this.size_picture = size_picture;
	}
	public int getGoods_remain() {
		return goods_remain;
	}
	public void setGoods_remain(int goods_remain) {
		this.goods_remain = goods_remain;
	}	
  
}
