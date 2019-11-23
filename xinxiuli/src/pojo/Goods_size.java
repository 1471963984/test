package pojo;

import java.io.Serializable;

public class Goods_size implements Serializable{
   private static final long serialVersionUID = -7633349157509252215L;
   private int sid;
   private int goods_id;
   private int color_num;
   private int size_num;
   private String size_name;
   private String size_picture;
   private int goods_remain;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
	public int getSize_num() {
		return size_num;
	}
	public void setSize_num(int size_num) {
		this.size_num = size_num;
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
