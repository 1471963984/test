package dto;

import java.io.Serializable;

public class AdminAllUserInfo implements Serializable{
	private static final long serialVersionUID = 6198920621538164623L;
	private int usersid;
    private String accountnum;
    private String[] userphone;
    private String[] username;
    private String[] usernick;
    private String[] useremail;
    private String[] useraddr;
//    记录默认地址的位置
    private int index;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String[] getUseraddr() {
		return useraddr;
	}
	public void setUseraddr(String[] useraddr) {
		this.useraddr = useraddr;
	}
	public int getUsersid() {
		return usersid;
	}
	public void setUsersid(int usersid) {
		this.usersid = usersid;
	}
	public String getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}
	public String[] getUserphone() {
		return userphone;
	}
	public void setUserphone(String[] userphone) {
		this.userphone = userphone;
	}
	public String[] getUsername() {
		return username;
	}
	public void setUsername(String[] username) {
		this.username = username;
	}
	public String[] getUsernick() {
		return usernick;
	}
	public void setUsernick(String[] usernick) {
		this.usernick = usernick;
	}
	public String[] getUseremail() {
		return useremail;
	}
	public void setUseremail(String[] useremail) {
		this.useremail = useremail;
	}
    
}
