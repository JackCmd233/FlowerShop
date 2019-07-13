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
	//去添加类型
	@Override
	public String toAddType(Model model) {
		//将查询到的所有类型传到allTypes中
		model.addAttribute("allTypes", adminTypeDao.selectGoodsType());
		return "admin/addType";//跳转到addType页面
	}
	//添加类型
	@Override
	public String addType(String typename, Model model, HttpSession session) {
		//添加类型名称
		adminTypeDao.addType(typename);
		//添加商品与修改商品页面使用
		session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
		return "forward:/adminType/toAddType";//请求转发到/adminType/toAddType
	}
	//去删除类型
	@Override
	public String toDeleteType(Model model) {
		model.addAttribute("allTypes", adminTypeDao.selectGoodsType());
		return "admin/deleteType";
	}
	//删除类型
	@Override
	public String deleteType(Integer id, Model model) {
		//类型有关联
		if(adminTypeDao.selectGoodsByType(id).size() > 0) {
			model.addAttribute("msg", "类型有关联，不允许删除！");
			return "forward:/adminType/toDeleteType";
		}
		if(adminTypeDao.deleteType(id) > 0) 
			model.addAttribute("msg", "类型成功删除！");
		//回到删除页面
		return "forward:/adminType/toDeleteType";
	}
	
}
