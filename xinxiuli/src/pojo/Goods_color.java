package pojo;

import java.io.Serializable;

public class Goods_color implements Serializable{
	
	private static final long serialVersionUID = -3881073657252943279L;
	private int pid;
	private int goods_id;
	private int color_num;
	private String color_name;
	private String goods_delpicture;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getColor_num() {
		return color_num;
	}
	public void setColor_num(int color_num) {
		this.color_num = color_num;
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
    
}
