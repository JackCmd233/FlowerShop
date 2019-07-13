package com.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.po.Goods;

public interface IndexService {
	public String before(Model model,HttpSession session, Goods goods);//首页
	public String toRegister(Model model);//去注册
	public String toLogin(Model model);//去登录
	public String goodsDetail(Model model,Integer id);//商品详情
	public String selectANotice(Model model,Integer id);//查询一个公告
	public String search(Model model,String mykey);//首页查询（花的名称或类型）
}
