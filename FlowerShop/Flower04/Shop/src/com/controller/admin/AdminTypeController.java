package com.controller.admin;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.GoodsType;
import com.service.admin.AdminTypeService;


@Controller
@RequestMapping("/adminType")
public class AdminTypeController extends BaseController {
	@Autowired
	private AdminTypeService adminTypeService;
	
	//��ѯ��Ʒ����
	@RequestMapping("/selectGoodsType")
	public String selectGoodsType(Model model, Integer pageCur, String act) {
		return adminTypeService.selectGoodsType(model, pageCur, act);
	}
	//ȥ����ҳ��
	@RequestMapping("toAddType")
	public String toAddType(Model model,HttpSession session) {
		model.addAttribute("goodstype", new GoodsType());
		return "admin/addType";
	}
	//������Ʒ����
	@RequestMapping("/addType")
	public String addType(GoodsType goodsType,Model model) {
		return adminTypeService.addType(goodsType, model);
	}
	
	//ɾ����Ʒ����
	@RequestMapping("/deleteAGoodsType")
	public String deleteAGoodsType(Integer tid,Model model) {
		return adminTypeService.deleteAGoodsType(tid, model);
	}
	

//	// ����������ҳ��
//	@RequestMapping("/toAddType")
//	public String toAddType(Model model) {
//		return adminTypeService.toAddType(model);
//	}
//
//	// ��������ʾҳ��
//	@RequestMapping("/toShowType")
//	public String toShowType(Model model, HttpServletRequest request,
//			@RequestParam(required = false, defaultValue = "1") int page) {
//		return adminTypeService.toShowType(model, request, page);
//	}
//
//	// ��������
//	@RequestMapping("/addType")
//	public String addType(GoodsType goodsType, Model model, HttpSession session) {
//		return adminTypeService.addType(goodsType, model, session);
//	}
//
//	// ��ɾ��ҳ��
//	@RequestMapping("/toDeleteType")
//	public String toDeleteType(Model model, HttpServletRequest request,
//			@RequestParam(required = false, defaultValue = "1") int page) {
//		// request.setAttribute("pageTool", PageUtil.getPageTool(request, 4, page, 2));
//		// System.out.println("deletetype");
//		return adminTypeService.toDeleteType(model, request, page);
//	}
//
//	// ɾ������
//	@RequestMapping("/deleteType")
//	public String deleteType(Integer id, Model model) {
//		return adminTypeService.deleteType(id, model);
//	}

}