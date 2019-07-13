package com.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface CartService {
	public String focus(Model model,Integer id, HttpSession session);//关注商品后回到详情页面
	public String putCart(Model model,Integer shoppingnum, Integer id, HttpSession session);//加入购物车后回到购物车页面
	public String selectCart(Model model, HttpSession session);//查询购物车
	public String deleteAgoods(Integer id,HttpSession session);//删除购物车中一个商品后回到购物车页面
	public String clear(HttpSession session);//清除购物车后回到购物车页面
	public String orderConfirm(Model model, HttpSession session);//订单信息页面
}
