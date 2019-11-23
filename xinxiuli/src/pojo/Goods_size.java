package pojo;

import java.io.Serializable;

public class Goods_size implements Serializable{
   private static final long serialVersionUID = -7633349157509252215L;
   private int sid;
   private int goods_id;
   private int size_num;
   private String size_name;
   private byte[] size_picture;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
	public byte[] getSize_picture() {
		return size_picture;
	}
	public void setSize_picture(byte[] size_picture) {
		this.size_picture = size_picture;
	}
   
}
