package pojo;

import java.io.Serializable;

public class Goods_detail implements Serializable{
	private static final long serialVersionUID = 1779916533837767177L;
	private int detail_id;
	private int goods_id;
	private byte[] first_picture;
	private byte[] second_picture;
	private byte[] details_picture;
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
	public byte[] getFirst_picture() {
		return first_picture;
	}
	public void setFirst_picture(byte[] first_picture) {
		this.first_picture = first_picture;
	}
	public byte[] getSecond_picture() {
		return second_picture;
	}
	public void setSecond_picture(byte[] second_picture) {
		this.second_picture = second_picture;
	}
	public byte[] getDetails_picture() {
		return details_picture;
	}
	public void setDetails_picture(byte[] details_picture) {
		this.details_picture = details_picture;
	}
}
