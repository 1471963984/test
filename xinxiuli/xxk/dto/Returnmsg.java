package dto;

import java.io.Serializable;

public class Returnmsg implements Serializable{  
 private static final long serialVersionUID = 2000324508320614566L;
   int code;
   String msg;
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public Returnmsg(int code, String msg) {
	this.code = code;
	this.msg = msg;
}
public Returnmsg() {
	
}
@Override
public String toString() {
	return "Returnmsg [code=" + code + ", msg=" + msg + "]";
}
   
}
