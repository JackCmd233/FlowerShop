package com.service.before;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;

import com.po.pojo.CenterOrder;
import com.po.pojo.Password;

public interface UserCenterService {
	public String showFocus(Model model,HttpSession session,Integer pageCur);//显示我的关注
	public String deleteFocus(Integer goodId,Model model,HttpSession session,Integer pageCur);//删除我的关注
	public Password updatePassword(Password password,HttpSession session);//修改用户密码
	public CenterOrder showPayOrder(CenterOrder centerOrder,HttpSession session);//显示和删除所有已支付订单
	public CenterOrder showNoPayOrder(CenterOrder centerOrder,HttpSession session);//显示和删除所有未支付订单
}
