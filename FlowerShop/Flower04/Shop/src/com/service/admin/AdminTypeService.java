package com.service.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;

import com.po.GoodsType;


public interface AdminTypeService {
	
	public String selectGoodsType(Model model, Integer pageCur, String act);//��ѯ������Ʒ����
	public String addType(GoodsType goodsType,Model model);//������� 
	public String deleteAGoodsType(Integer tid,Model model);//ɾ��һ����Ʒ����
}
