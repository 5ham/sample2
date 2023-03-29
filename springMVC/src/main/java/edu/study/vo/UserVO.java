package edu.study.vo;

//vo는 필드명은 반드시 getter,setter 에서 필드명 첫글자 대문자로 시작할 수 있도록 이름 짓는다.
public class UserVO {
	private int uno;
	private String uid;
	private String upw;
	private String uname;
	private String ugender;
	private String uretire;
	private String ujoindate;
	private String ucode;
	
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUgender() {
		return ugender;
	}
	public void setUgender(String ugender) {
		this.ugender = ugender;
	}
	public String getUretire() {
		return uretire;
	}
	public void setUretire(String uretire) {
		this.uretire = uretire;
	}
	public String getUjoindate() {
		return ujoindate;
	}
	public void setUjoindate(String ujoindate) {
		this.ujoindate = ujoindate;
	}
	public String getUcode() {
		return ucode;
	}
	public void setUcode(String ucode) {
		this.ucode = ucode;
	}
}
