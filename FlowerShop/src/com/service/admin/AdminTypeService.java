package com.service.admin;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;

public interface AdminTypeService {
	public String toAddType(Model model);//去添加类型页面
	public String addType(String typename,Model model,HttpSession session);//添加类型
	public String toDeleteType(Model model);//去删除类型页面
	public String deleteType(Integer id,Model model);//删除类型
}
