package pojo;

import java.io.Serializable;

public class Goods_detail implements Serializable{
	private static final long serialVersionUID = 1779916533837767177L;
	private int detail_id;
	private int goods_id;
	private String first_picture;
	private String second_picture;
	private String thried_picture;
	private String details_picture;
	public int getDetail_id() {
		return detail_id;
	}
	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getFirst_picture() {
		return first_picture;
	}
	public void setFirst_picture(String first_picture) {
		this.first_picture = first_picture;
	}
	public String getSecond_picture() {
		return second_picture;
	}
	public void setSecond_picture(String second_picture) {
		this.second_picture = second_picture;
	}
	public String getDetails_picture() {
		return details_picture;
	}
	public void setDetails_picture(String details_picture) {
		this.details_picture = details_picture;
	}
	public String getThried_picture() {
		return thried_picture;
	}
	public void setThried_picture(String thried_picture) {
		this.thried_picture = thried_picture;
	}
	
}
