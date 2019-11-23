package pojo;

import java.io.Serializable;

public class Users implements Serializable{
	private static final long serialVersionUID = -751723049697319112L;
	 private int users_id;
     private String account_num;
     private String users_name;
     private String users_nickname;
     private String users_addr;
     private String users_email;
     private String users_phone;
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public String getUsers_name() {
		return users_name;
	}
	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}
	public String getUsers_nickname() {
		return users_nickname;
	}
	public void setUsers_nickname(String users_nickname) {
		this.users_nickname = users_nickname;
	}
	public String getUsers_addr() {
		return users_addr;
	}
	public void setUsers_addr(String users_addr) {
		this.users_addr = users_addr;
	}
	public String getUsers_email() {
		return users_email;
	}
	public void setUsers_email(String users_email) {
		this.users_email = users_email;
	}
	public String getUsers_phone() {
		return users_phone;
	}
	public void setUsers_phone(String users_phone) {
		this.users_phone = users_phone;
	}
}
