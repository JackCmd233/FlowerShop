package com.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.po.Goods;

public interface IndexService {
	public String before(Model model,HttpSession session, Goods goods);//��ҳ
	public String toRegister(Model model);//ȥע��
	public String toLogin(Model model);//ȥ��¼
	public String goodsDetail(Model model,Integer id);//��Ʒ����
	public String selectANotice(Model model,Integer id);//��ѯһ������
	public String search(Model model,String mykey);//��ҳ��ѯ���������ƻ����ͣ�
}
