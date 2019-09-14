package com.po.pojo;

import java.util.List;

import com.po.Order;

public class CenterOrder {
	private List<Order> orders;
	private String msg;
	private int pageCur;
	private int totalPage;
	private Integer deleteId;
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getPageCur() {
		return pageCur;
	}
	public void setPageCur(int pageCur) {
		this.pageCur = pageCur;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(Integer deleteId) {
		this.deleteId = deleteId;
	}
}
