package com.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface CartService {
	public String focus(Model model,Integer id, HttpSession session);//��ע��Ʒ��ص�����ҳ��
	public String putCart(Model model,Integer shoppingnum, Integer id, HttpSession session);//���빺�ﳵ��ص����ﳵҳ��
	public String selectCart(Model model, HttpSession session);//��ѯ���ﳵ
	public String deleteAgoods(Integer id,HttpSession session);//ɾ�����ﳵ��һ����Ʒ��ص����ﳵҳ��
	public String clear(HttpSession session);//������ﳵ��ص����ﳵҳ��
	public String orderConfirm(Model model, HttpSession session);//������Ϣҳ��
}
