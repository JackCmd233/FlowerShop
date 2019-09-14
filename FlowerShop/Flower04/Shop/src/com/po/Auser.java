package com.po;

/*与数据表ausertable对应*/
public class Auser {
	private Integer id;//管理员id
	private String aname;//管理员名字
	private String apwd;//密码
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
}
