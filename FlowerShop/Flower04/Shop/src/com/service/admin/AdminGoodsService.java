package com.service.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.po.Goods;

public interface AdminGoodsService {
	public String selectGoods(Model model, Integer pageCur, String act);//��ѯ������Ʒ
	public String selectAGoods(Model model, Integer id, String act);//��ѯһ����Ʒ��Ϣ
	public String addOrUpdateGoods(Goods goods,HttpServletRequest request,Model model,String updateAct);//���ӻ��޸���Ʒ��Ϣ
	public String deleteAGoods(Integer id,Model model);//ɾ��һ����Ʒ
	public String deleteGoods(Integer ids[],Model model);//ɾ�������Ʒ
}