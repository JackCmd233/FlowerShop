package com.po;

public class Buser {
	private Integer id;//用户id
	private String bemail;//手机号或邮箱
	private String bpwd;//密码
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBemail() {
		return bemail;
	}
	public void setBemail(String bemail) {
		this.bemail = bemail;
	}
	public String getBpwd() {
		return bpwd;
	}
	public void setBpwd(String bpwd) {
		this.bpwd = bpwd;
	}
}
