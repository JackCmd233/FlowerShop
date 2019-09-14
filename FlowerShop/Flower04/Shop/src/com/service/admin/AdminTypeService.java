package com.service.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;

import com.po.GoodsType;


public interface AdminTypeService {
	
	public String selectGoodsType(Model model, Integer pageCur, String act);//查询所有商品类型
	public String addType(GoodsType goodsType,Model model);//添加类型 
	public String deleteAGoodsType(Integer tid,Model model);//删除一个商品类型
}
