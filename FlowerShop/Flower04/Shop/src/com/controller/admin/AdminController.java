package com.controller.admin;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.po.Auser;
import com.service.admin.AdminService;
@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	//跳转到登录界面
	@RequestMapping("/admin")
	public String toLogin(@ModelAttribute Auser auser) {
		return "admin/login";
	}
	//测试是否能登录
	@RequestMapping("/admin/login")
	public String login(@ModelAttribute Auser auser, Model model, HttpSession session) {
		return adminService.login(auser, model, session);
	}
	//安全退出
	@RequestMapping("/exit")
	public String exit(@ModelAttribute Auser auser,HttpSession session) {
		session.invalidate();
		return "admin/login";
	}
}
