package com.controller.before;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.po.pojo.CenterOrder;
import com.po.pojo.Password;
import com.service.before.UserCenterService;

@Controller

public class UserCenterController extends BaseBeforeController{
	@Autowired
	private UserCenterService userCenterService;
	@RequestMapping("/userCenter")
	public String userCenter(Model model,HttpSession session,Integer pageCur) {
		return userCenterService.showFocus(model, session, pageCur);
	}
	@RequestMapping("/deleteFocus")
	public String deleteFocus(Integer goodId,Model model,HttpSession session,Integer pageCur) {
		return userCenterService.deleteFocus(goodId, model, session,pageCur);
	}
	@RequestMapping("/updatepassword")
	@ResponseBody
	public Password updatepassword(@RequestBody Password password,HttpSession session) {
		return userCenterService.updatePassword(password, session);
		
	}
	@RequestMapping("/showPayOrder")
	@ResponseBody
	public CenterOrder showPayOrder(@RequestBody CenterOrder centerOrder,HttpSession session) {
		return userCenterService.showPayOrder(centerOrder,session);
	}
	@RequestMapping("/showNoPayOrder")
	@ResponseBody
	public CenterOrder showNoPayOrder(@RequestBody CenterOrder centerOrder,HttpSession session) {
		return userCenterService.showNoPayOrder(centerOrder,session);
	}
}

