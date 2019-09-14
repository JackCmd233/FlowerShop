package com.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.pojo.QueryOrder;
import com.service.admin.AdminOrderService;

@Controller
@RequestMapping("/adminOrder")
public class AdminOrderController extends BaseController{
	@Autowired
	private AdminOrderService adminOrderService;
	//查看订单详情
	@RequestMapping("/orderInfo")
	public String orderInfo(Model model,Integer pageCur) {
		return adminOrderService.orderInfo(model,pageCur);
	}
	
	//根据条件查订单详情
	@RequestMapping("/orderFactor")
	public String orderInfo(Model model,Integer pageCur,String status,String payway,String time1,String time2) {
		QueryOrder queryOrder=new QueryOrder();
		queryOrder.setStatus(status);
		queryOrder.setPayway(payway);
		queryOrder.setTime1(time1);
		queryOrder.setTime2(time2);
		return adminOrderService.orderInfoByFactor(model,pageCur,queryOrder);
	}
}
