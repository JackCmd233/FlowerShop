package com.service.before;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.dao.UserCenterDao;
import com.util.MyUtil;
@Service("userCenterService")
@Transactional
public class UserCenterServiceImpl implements UserCenterService{
	@Autowired
	private UserCenterDao userCenterDao;
	//用户中心（显示我的订单和关注信息）
	@Override
	public String userCenter(HttpSession session, Model model) {
		model.addAttribute("myOrder", userCenterDao.myOrder(MyUtil.getUserId(session)));
		model.addAttribute("myFocus", userCenterDao.myFocus(MyUtil.getUserId(session)));
		return "before/userCenter";
	}
	//订单详情
	@Override
	public String orderDetail(Model model, Integer ordersn) {
		model.addAttribute("myOrderDetail", userCenterDao.orderDetail(ordersn));
		return "before/userOrderDetail";
	}

}
