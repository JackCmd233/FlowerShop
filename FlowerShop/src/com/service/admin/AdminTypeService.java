package com.service.admin;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;

public interface AdminTypeService {
	public String toAddType(Model model);//ȥ�������ҳ��
	public String addType(String typename,Model model,HttpSession session);//�������
	public String toDeleteType(Model model);//ȥɾ������ҳ��
	public String deleteType(Integer id,Model model);//ɾ������
}
