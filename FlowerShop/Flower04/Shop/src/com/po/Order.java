package com.po;

public class Order {
	private Integer id;//����id
	private Integer busertable_id;//�û�id
	private Double amount;//�������
	private Integer status;//����״̬
	private String orderdate;//�µ�ʱ��
	private String payway;//֧����ʽ
	private Integer buseraddress_id;//������ַid
	private Integer deletestatus;//ǰ̨�û��Ƿ�ɾ������
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBusertable_id() {
		return busertable_id;
	}
	public void setBusertable_id(Integer busertable_id) {
		this.busertable_id = busertable_id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getPayway() {
		return payway;
	}
	public void setPayway(String payway) {
		this.payway = payway;
	}
	public Integer getBuseraddress_id() {
		return buseraddress_id;
	}
	public void setBuseraddress_id(Integer buseraddress_id) {
		this.buseraddress_id = buseraddress_id;
	}
	public Integer getDeletestatus() {
		return deletestatus;
	}
	public void setDeletestatus(Integer deletestatus) {
		this.deletestatus = deletestatus;
	}
}
