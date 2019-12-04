package dto;

public class Admproductlist {
   int     goods_num;
   int     goods_id;
   String  goods_picture;
   String  goods_name;
   Double  goods_price;
   int     goods_remain;
   String  color_name;
   String  size_name;
public int getGoods_num() {
	return goods_num;
}
public void setGoods_num(int goods_num) {
	this.goods_num = goods_num;
}
public int getGoods_id() {
	return goods_id;
}
public void setGoods_id(int goods_id) {
	this.goods_id = goods_id;
}
public String getGoods_picture() {
	return goods_picture;
}
public void setGoods_picture(String goods_picture) {
	this.goods_picture = goods_picture;
}
public String getGoods_name() {
	return goods_name;
}
public void setGoods_name(String goods_name) {
	this.goods_name = goods_name;
}
public Double getGoods_price() {
	return goods_price;
}
public void setGoods_price(Double goods_price) {
	this.goods_price = goods_price;
}
public int getGoods_remain() {
	return goods_remain;
}
public void setGoods_remain(int goods_remain) {
	this.goods_remain = goods_remain;
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
@Override
public String toString() {
	return "Admproductlist [goods_bum=" + goods_num + ", goods_id=" + goods_id + ", goods_picture=" + goods_picture
			+ ", goods_name=" + goods_name + ", goods_price=" + goods_price + ", goods_remain=" + goods_remain
			+ ", color_name=" + color_name + ", size_name=" + size_name + "]";
}
   
   
}
