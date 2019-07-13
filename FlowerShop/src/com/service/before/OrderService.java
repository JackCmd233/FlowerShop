package com.service.before;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
public interface OrderService {
	public String orderSubmit(Model model, HttpSession session,Double amount);//订单提交
	public String pay(Integer ordersn);//支付订单
}
