package com.service.admin;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.dao.AdminTypeDao;
@Service("adminTypeService")
@Transactional
public class AdminTypeServiceImpl implements AdminTypeService{
	@Autowired
	private AdminTypeDao adminTypeDao;
	//ȥ�������
	@Override
	public String toAddType(Model model) {
		//����ѯ�����������ʹ���allTypes��
		model.addAttribute("allTypes", adminTypeDao.selectGoodsType());
		return "admin/addType";//��ת��addTypeҳ��
	}
	//�������
	@Override
	public String addType(String typename, Model model, HttpSession session) {
		//�����������
		adminTypeDao.addType(typename);
		//�����Ʒ���޸���Ʒҳ��ʹ��
		session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
		return "forward:/adminType/toAddType";//����ת����/adminType/toAddType
	}
	//ȥɾ������
	@Override
	public String toDeleteType(Model model) {
		model.addAttribute("allTypes", adminTypeDao.selectGoodsType());
		return "admin/deleteType";
	}
	//ɾ������
	@Override
	public String deleteType(Integer id, Model model) {
		//�����й���
		if(adminTypeDao.selectGoodsByType(id).size() > 0) {
			model.addAttribute("msg", "�����й�����������ɾ����");
			return "forward:/adminType/toDeleteType";
		}
		if(adminTypeDao.deleteType(id) > 0) 
			model.addAttribute("msg", "���ͳɹ�ɾ����");
		//�ص�ɾ��ҳ��
		return "forward:/adminType/toDeleteType";
	}
	
}
