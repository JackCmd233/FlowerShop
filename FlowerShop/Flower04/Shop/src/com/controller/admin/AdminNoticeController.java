package com.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.Notice;
import com.service.admin.AdminNoticeService;
@Controller
@RequestMapping("/adminNotice")
public class AdminNoticeController extends BaseController{
	@Autowired
	private AdminNoticeService adminNoticeService;
	//转到addNotice界面
	@RequestMapping("/toAddNotice")
	public String toAddNotice(Model model) {
		model.addAttribute("notice", new Notice());
		return "admin/addNotice";
	}
	//添加公告
	@RequestMapping("/addNotice")
	public String addNotice(@ModelAttribute Notice notice) {
		return adminNoticeService.addNotice(notice);
	}
	//显示所有公告
	@RequestMapping("/deleteNoticeSelect")
	public String deleteNoticeSelect(Model model, Integer pageCur) {
		return adminNoticeService.deleteNoticeSelect(model,pageCur);
	}
//	//选择一条公告查看详情
//	@RequestMapping("/selectANotice")
//	public String selectANotice(Model model, Integer id) {
//		return adminNoticeService.selectANotice(model, id);
//	}
	//选择一条公告查看详情
	@RequestMapping("/selectANoticeById")
	public String selectANoticeById(Model model, Integer id, Integer pageCur) {
		return adminNoticeService.selectANoticeById(model, id, pageCur);
	}
	//删除某条公告
	@RequestMapping("/deleteNotice")
	public String deleteNotice(Integer id) {
		return adminNoticeService.deleteNotice(id);
	}
}
