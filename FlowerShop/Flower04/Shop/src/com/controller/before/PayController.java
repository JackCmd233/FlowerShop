package com.controller.before;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.service.before.CartService;

import com.alipay.api.AlipayApiException;
import com.po.pojo.AlipayBean;
import com.service.before.PayService;
import com.util.AlipayConfig;


@Controller
public class PayController extends BaseBeforeController{
	@Autowired
	private CartService cartService;
	
	@Autowired
	private PayService payService;
	
	/**
	 * 跳转到支付页面
	 */
	@RequestMapping("/toPay")
	public String toPay(Model model,HttpSession session,HttpServletRequest request,Integer id) {
		System.out.println("这是地址ID: "+id);
		return cartService.toPay(model, request, session, id);
	}
	
	@RequestMapping("/alipay")
	public void alipay(HttpServletResponse response,String orderId,String amount) throws AlipayApiException{
		AlipayBean alipayBean=new AlipayBean();
		alipayBean.setOrderId(orderId);
		alipayBean.setOrderName(orderId);
		alipayBean.setAmount(amount); 
		AlipayConfig alipayConfig=new AlipayConfig();
		try {
             response.setContentType("text/html; charset=utf-8");
             response.getWriter().write(alipayConfig.pay(alipayBean));
             response.getWriter().close();
         } catch (IOException e) {
             e.printStackTrace();
         }

	}

	@RequestMapping("/changePay")
	@ResponseBody
	public AlipayBean changePay(@RequestBody AlipayBean alipayBean){
		return payService.updateOrder(alipayBean);
	}
}
