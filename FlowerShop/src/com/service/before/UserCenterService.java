package com.service.before;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;

public interface UserCenterService {
	public String userCenter(HttpSession session, Model model);//到用户中心查看我的订单和关注信息
	public String orderDetail(Model model, Integer ordersn);//查看订单详情
}
