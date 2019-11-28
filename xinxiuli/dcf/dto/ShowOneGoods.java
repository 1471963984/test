package dto;

import java.io.Serializable;
import java.util.List;

import pojo.Goods_color;
import pojo.Goods_detail;
import pojo.Goods_size;

public class ShowOneGoods implements Serializable {
	private static final long serialVersionUID = 8925084883877392572L;
	//��Ʒ����
	private int goods_num;
	private int goods_id;
	private int divied_num;
	private String goods_desc;
	private double goods_price;
	private String goods_name;
	private int goods_star;
	private int goods_color_num;
	private int goods_size_num;
	private String goods_picture;

	private List<Goods_color> l;

	private	List<Goods_size> lsize;
//	细节图片对象
	private Goods_detail detail;
//   细节图片
	private String[] detailphoto;

	private String cid;
	//保存颜色组图
	private String[] colorphoto;
	
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
	public int getGoods_size_num() {
		return goods_size_num;
	}
	public void setGoods_size_num(int goods_size_num) {
		this.goods_size_num = goods_size_num;
	}

	
	
	public int getGoods_color_num() {
		return goods_color_num;
	}
	public void setGoods_color_num(int goods_color_num) {
		this.goods_color_num = goods_color_num;
	}
	public String getGoods_picture() {
		return goods_picture;
	}
	public void setGoods_picture(String goods_picture) {
		this.goods_picture = goods_picture;
	}
	public List<Goods_color> getL() {
		return l;
	}
	public void setL(List<Goods_color> l) {
		this.l = l;
	}
	
	
	public List<Goods_size> getLsize() {
		return lsize;
	}
	public void setLsize(List<Goods_size> lsize) {
		this.lsize = lsize;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String[] getColorphoto() {
		return colorphoto;
	}
	public void setColorphoto(String[] colorphoto) {
		this.colorphoto = colorphoto;
	}
	public Goods_detail getDetail() {
		return detail;
	}
	public void setDetail(Goods_detail detail) {
		this.detail = detail;
	}
	public String[] getDetailphoto() {
		return detailphoto;
	}
	public void setDetailphoto(String[] detailphoto) {
		this.detailphoto = detailphoto;
	}
		
}
