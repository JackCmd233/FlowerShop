package com.po;

import org.springframework.web.multipart.MultipartFile;

public class Goods {
	private Integer id;// ��Ʒid
	private String gname;// ����
	private Double goprice;// ԭ��
	private Double grprice;// �ּ�
	private Integer gstore;// ���
	private MultipartFile logoImage;// ��װ���ϴ����ļ���Ϣ
	private String gpicture;// ͼƬ
	private Integer goodstype_id;// ��Ʒ����id
	private String typename;// �������ƣ���ѯʱʹ��
	private String  productDesciption; //��Ʒ����

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGname() {
		return gname;
	}

	public String getProductDesciption() {
		return productDesciption;
	}

	public void setProductDesciption(String productDesciption) {
		this.productDesciption = productDesciption;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Double getGoprice() {
		return goprice;
	}

	public void setGoprice(Double goprice) {
		this.goprice = goprice;
	}

	public Double getGrprice() {
		return grprice;
	}

	public void setGrprice(Double grprice) {
		this.grprice = grprice;
	}

	public Integer getGstore() {
		return gstore;
	}

	public void setGstore(Integer gstore) {
		this.gstore = gstore;
	}

	public MultipartFile getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(MultipartFile logoImage) {
		this.logoImage = logoImage;
	}

	public String getGpicture() {
		return gpicture;
	}

	public void setGpicture(String gpicture) {
		this.gpicture = gpicture;
	}

	public Integer getGoodstype_id() {
		return goodstype_id;
	}

	public void setGoodstype_id(Integer goodstype_id) {
		this.goodstype_id = goodstype_id;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

}
