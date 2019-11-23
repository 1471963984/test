package pojo;

import java.io.Serializable;

public class Second_content implements Serializable{
	private static final long serialVersionUID = 5604997108716620606L;
    private int first_num;
    private int second_num;
    private String second_name;
	public int getFirst_num() {
		return first_num;
	}
	public void setFirst_num(int first_num) {
		this.first_num = first_num;
	}
	public int getSecond_num() {
		return second_num;
	}
	public void setSecond_num(int second_num) {
		this.second_num = second_num;
	}
	public String getSecond_name() {
		return second_name;
	}
	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}
}
