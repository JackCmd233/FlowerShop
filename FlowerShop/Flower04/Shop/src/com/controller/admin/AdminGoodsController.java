package com.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.AdminGoodsDao;
import com.po.Goods;
import com.service.admin.AdminGoodsService;

@Controller
@RequestMapping("/adminGoods")
public class AdminGoodsController extends BaseController {
	@Autowired
	private AdminGoodsService adminGoodsService;
	@Autowired
	private AdminGoodsDao adminGoodsDao;
	//查看商品
	@RequestMapping("/selectGoods")
	public String selectGoods(Model model, Integer pageCur, String act) {
		return adminGoodsService.selectGoods(model, pageCur, act);
	}
	//查询一个商品
	@RequestMapping("/selectAGoods")
	public String selectAGoods(Model model, Integer id, String act){
		return adminGoodsService.selectAGoods(model, id, act);
	}
	//添加商品页面初始化
	@RequestMapping("/toAddGoods")
	public String toAddGoods(Model model,HttpSession session){
		model.addAttribute("goods", new Goods());
		//添加商品与修改商品页面使用
		session.setAttribute("goodsType", adminGoodsDao.selectGoodsType());
		//model.addAttribute("goodsType", adminGoodsDao.selectGoodsType());
		return "admin/addGoods";
	}
//	//修改商品页面初始化
//	@RequestMapping("toUpdateGoods")
//	public String toUpdateGoods(Model model) {
//		model.addAttribute("goodsType", adminGoodsDao.selectGoodsType());
//		return "admin/updateAgoods";
//	}
	//添加与修改
	@RequestMapping("/addGoods")
	public String addGoods(@ModelAttribute Goods goods, HttpServletRequest request,Model model, String updateAct){
		return adminGoodsService.addOrUpdateGoods(goods, request, model, updateAct);
	}	
	//删除一个商品
	@RequestMapping("deleteAGoods")
	public String deleteAGoods(Integer id,Model model) {
		return adminGoodsService.deleteAGoods(id, model);
	}	
	//删除多个商品
	@RequestMapping("deleteGoods")
	public String deleteGoods(Integer ids[],Model model) {
		return adminGoodsService.deleteGoods(ids, model);
	}
}
